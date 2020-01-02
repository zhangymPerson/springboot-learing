# 权限部分

## Json web token (JWT)

### JWT包含了三部分：

> token的结构 xxxxxx.yyyyyy.zzzzzz


- Header 

    **头部(标题包含了令牌的元数据，并且包含签名和/或加密算法的类型)**

    JWT头部分是一个描述JWT元数据的JSON对象，通常如下所示。
    ```json
    {
    
      "alg": "HS256",
    
      "typ": "JWT"
    
    }
   ```
    
    在上面的代码中，alg属性表示签名使用的算法，默认为HMAC SHA256（写为HS256）；typ属性表示令牌的类型，JWT令牌统一写为JWT。
    
    最后，使用Base64 URL算法将上述JSON对象转换为字符串保存。

- Payload 

    **负载 (类似于飞机上承载的物品)**
    
    有效载荷部分，是JWT的主体内容部分，也是一个JSON对象，包含需要传递的数据。 JWT指定七个默认字段供选择。
    
    iss：发行人
    
    exp：到期时间
    
    sub：主题
    
    aud：用户
    
    nbf：在此之前不可用
    
    iat：发布时间
    
    jti：JWT ID用于标识该JWT
    
    除以上默认字段外，我们还可以自定义私有字段，如下例：
    ```json
    {
    
      "sub": "1234567890",
    
      "name": "chongchong",
    
      "admin": true
    
    }
    ```
    
    请注意，默认情况下JWT是未加密的，任何人都可以解读其内容，因此不要构建隐私信息字段，存放保密信息，以防止信息泄露。
    
    JSON对象也使用Base64 URL算法转换为字符串保存。
- Signature 签名/签证

    **签名哈希部分是对上面两部分数据签名，通过指定的算法生成哈希，以确保数据不会被篡改。**
    
    首先，需要指定一个密码（secret）。该密码仅仅为保存在服务器中，并且不能向用户公开。然后，使用标头中指定的签名算法（默认情况下为HMAC SHA256）根据公式生成签名。 

    如果是使用HMAC SHA256算法，则如下规则
    
    HMACSHA256(
      base64UrlEncode(header) + "." +
      base64UrlEncode(payload),
      secret)
    
    在计算出签名哈希后，JWT头，有效载荷和签名哈希的三个部分组合成一个字符串，每个部分用"."分隔，就构成整个JWT对象。