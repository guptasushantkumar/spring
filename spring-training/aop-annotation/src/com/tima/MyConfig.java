package com.tima;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.tima")
@EnableAspectJAutoProxy
public class MyConfig {

}
