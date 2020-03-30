package com.yoke.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevEnvironment implements EnvironmentInterface{
}
