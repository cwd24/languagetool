/* LanguageTool, a natural language style checker 
 * Copyright (C) 2012 Marcin Miłkowski (http://www.languagetool.org)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

package org.languagetool.rules.ru;

import java.io.IOException;
import java.util.ResourceBundle;

import org.languagetool.Language;
import org.languagetool.rules.Example;
import org.languagetool.rules.spelling.morfologik.MorfologikSpellerRule;

public final class MorfologikRussianSpellerRule extends MorfologikSpellerRule {

  public static final String RULE_ID = "MORFOLOGIK_RULE_RU_RU";

  private static final String RESOURCE_FILENAME = "/ru/hunspell/ru_RU.dict";

  public MorfologikRussianSpellerRule(ResourceBundle messages, Language language) throws IOException {
    super(messages, language);
    addExamplePair(Example.wrong("Все счастливые семьи похожи друг на друга, <marker>каждя</marker> несчастливая семья несчастлива по-своему."),
                   Example.fixed("Все счастливые семьи похожи друг на друга, <marker>каждая</marker> несчастливая семья несчастлива по-своему."));
  }

  @Override
  public String getFileName() {
    return RESOURCE_FILENAME;
  }

  @Override
  public String getId() {
    return RULE_ID;
  }

}
