package com.weyon.security.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author stan
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
     * 配置静态访问资源
     * 且不会覆盖之前的配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
    
    /**
     * 使用fastjson代替jackson
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
        while(iterator.hasNext()){
            HttpMessageConverter<?> converter = iterator.next();
            if(converter instanceof MappingJackson2HttpMessageConverter){
                iterator.remove();
            }
        }
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // List类型字段为null时输出[]而非null
                SerializerFeature.WriteNullListAsEmpty,
                // 显示空字段
                SerializerFeature.WriteMapNullValue,
                // 字符串类型字段为null时间输出""而非null
                SerializerFeature.WriteNullStringAsEmpty,
                // Boolean类型字段为null时输出false而null
                SerializerFeature.WriteNullBooleanAsFalse,
                // 美化json输出，否则会作为整行输出
                SerializerFeature.PrettyFormat,
                // 数值字段如果为null,输出为0,而非null
                SerializerFeature.WriteNullNumberAsZero,
                // Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                // 时间格式yyyy-MM-dd HH: mm: ss
                SerializerFeature.WriteDateUseDateFormat,
                // 禁用循环引用检测
                SerializerFeature.DisableCircularReferenceDetect);
        // 此处是全局处理方式
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(config);
        converters.add(converter);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(supportedMediaTypes);
    }
}
