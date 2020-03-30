package com.yoke.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class QAEnvironment implements EnvironmentInterface {
}
