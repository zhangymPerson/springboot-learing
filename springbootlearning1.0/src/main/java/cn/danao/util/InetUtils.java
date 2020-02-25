package cn.danao.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cn.danao.util.Constants.*;

/**
 * date 2020/2/20 15:24 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class InetUtils {

    private static final Logger log = LoggerFactory.getLogger(InetUtils.class);

    private static String selfIp;

    private static boolean useOnlySiteLocalInterface = false;

    private static boolean preferHostnameOverIp = false;

    private static List<String> preferredNetworks = new ArrayList<String>();

    private static List<String> ignoredInterfaces = new ArrayList<String>();

    static {

        List<String> networks = PropertyUtils.getPropertyList(PREFERRED_NETWORKS);
        for (String preferred : networks) {
            preferredNetworks.add(preferred);
        }

        List<String> interfaces = PropertyUtils.getPropertyList(IGNORED_INTERFACES);
        for (String ignored : interfaces) {
            ignoredInterfaces.add(ignored);
        }

        String nacosIp = System.getProperty(NACOS_SERVER_IP);
        if (StringUtils.isBlank(nacosIp)) {
            nacosIp = PropertyUtils.getProperty(IP_ADDRESS);
        }

        if (!StringUtils.isBlank(nacosIp) && !isIP(nacosIp)) {
            throw new RuntimeException("nacos address " + nacosIp + " is not ip");
        }

        selfIp = nacosIp;

        if (StringUtils.isBlank(selfIp)) {
            preferHostnameOverIp = Boolean.getBoolean(SYSTEM_PREFER_HOSTNAME_OVER_IP);

            if (!preferHostnameOverIp) {
                preferHostnameOverIp = Boolean.parseBoolean(PropertyUtils.getProperty(PREFER_HOSTNAME_OVER_IP));
            }

            if (preferHostnameOverIp) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                }
                if (inetAddress.getHostName().equals(inetAddress.getCanonicalHostName())) {
                    selfIp = inetAddress.getHostName();
                } else {
                    selfIp = inetAddress.getCanonicalHostName();
                }
            } else {
                selfIp = findFirstNonLoopbackAddress().getHostAddress();
            }
        }
    }

    public static String getSelfIp() {
        return selfIp;
    }

    public static InetAddress findFirstNonLoopbackAddress() {
        InetAddress result = null;

        try {
            int lowest = Integer.MAX_VALUE;
            for (Enumeration<NetworkInterface> nics = NetworkInterface
                    .getNetworkInterfaces(); nics.hasMoreElements(); ) {
                NetworkInterface ifc = nics.nextElement();
                if (ifc.isUp()) {
                    log.info("Testing interface: " + ifc.getDisplayName());
                    if (ifc.getIndex() < lowest || result == null) {
                        lowest = ifc.getIndex();
                    } else if (result != null) {
                        continue;
                    }

                    if (!ignoreInterface(ifc.getDisplayName())) {
                        for (Enumeration<InetAddress> addrs = ifc
                                .getInetAddresses(); addrs.hasMoreElements(); ) {
                            InetAddress address = addrs.nextElement();
                            if (address instanceof Inet4Address
                                    && !address.isLoopbackAddress()
                                    && isPreferredAddress(address)) {
                                log.info("Found non-loopback interface: "
                                        + ifc.getDisplayName());
                                result = address;
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            log.error("Cannot get first non-loopback address", ex);
        }

        if (result != null) {
            return result;
        }

        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.warn("Unable to retrieve localhost");
        }

        return null;
    }

    public static boolean isPreferredAddress(InetAddress address) {
        if (useOnlySiteLocalInterface) {
            final boolean siteLocalAddress = address.isSiteLocalAddress();
            if (!siteLocalAddress) {
                log.info("Ignoring address: " + address.getHostAddress());
            }
            return siteLocalAddress;
        }
        if (preferredNetworks.isEmpty()) {
            return true;
        }
        for (String regex : preferredNetworks) {
            final String hostAddress = address.getHostAddress();
            if (hostAddress.matches(regex) || hostAddress.startsWith(regex)) {
                return true;
            }
        }

        return false;
    }

    public static boolean ignoreInterface(String interfaceName) {
        for (String regex : ignoredInterfaces) {
            if (interfaceName.matches(regex)) {
                log.info("Ignoring interface: " + interfaceName);
                return true;
            }
        }
        return false;
    }

    public static boolean isIP(String str) {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
        return match(regex, str);
    }

    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
