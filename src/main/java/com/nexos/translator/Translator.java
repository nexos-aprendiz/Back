package com.nexos.translator;

import org.springframework.stereotype.Component;

@Component
public interface Translator<A, B> {

	B translate(A l);

}
