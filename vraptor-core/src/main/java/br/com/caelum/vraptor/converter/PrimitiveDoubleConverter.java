/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.caelum.vraptor.converter;

import static com.google.common.base.Strings.isNullOrEmpty;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

/**
 * VRaptor's primitive double converter.
 *
 * @author Cecilia Fernandes
 */
@Convert(double.class)
@ApplicationScoped
public class PrimitiveDoubleConverter implements Converter<Double> {
    @Override
	public Double convert(String value, Class<? extends Double> type) {
        if (isNullOrEmpty(value)) {
            return 0d;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new ConversionException(new ConversionMessage("is_not_a_valid_number", value));
        }
    }

}
