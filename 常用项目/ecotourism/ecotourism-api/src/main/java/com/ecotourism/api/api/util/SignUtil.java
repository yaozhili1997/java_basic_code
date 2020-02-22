/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ecotourism.api.api.util;

import com.ecotourism.api.common.utils.MD5;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/**
 * 签名工具
 */
public class SignUtil {
    //签名算法HmacSha256
    public static final String HMAC_SHA256 = "HmacSHA256";
    //编码UTF-8
    public static final String ENCODING = "UTF-8";

	public static String sign(String secret) {
		try {
			Mac hmacSha256 = Mac.getInstance(HMAC_SHA256);
			byte[] keyBytes = secret.getBytes(ENCODING);
			hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length,
					HMAC_SHA256));
			return MD5.md5(new String(Base64.encodeBase64(hmacSha256.doFinal(keyBytes))));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static String sign(String cid, String appKey, String secret,String jsonData)
	{	
		try {
				Mac hmacSha256 = Mac.getInstance(HMAC_SHA256);
				byte[] keyBytes = (cid+appKey+secret+jsonData).toString().getBytes(ENCODING);
				hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length,
						HMAC_SHA256));

				return MD5.md5(new String(Base64.encodeBase64(hmacSha256.doFinal(keyBytes))));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
}
