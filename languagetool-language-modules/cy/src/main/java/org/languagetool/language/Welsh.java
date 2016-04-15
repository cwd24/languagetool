/* LanguageTool, a natural language style checker 
 * Copyright (C) 2011 Daniel Naber (http://www.danielnaber.de)
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

package org.languagetool.language;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.languagetool.Language;
import org.languagetool.rules.*;
//import org.languagetool.rules.br.TopoReplaceRule;
//import org.languagetool.rules.br.MorfologikBretonSpellerRule;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.xx.DemoTagger;
//import org.languagetool.tagging.br.BretonTagger;
//import org.languagetool.tagging.disambiguation.Disambiguator;
//import org.languagetool.tagging.disambiguation.rules.XmlRuleDisambiguator;
//import org.languagetool.tokenizers.Tokenizer;
//import org.languagetool.tokenizers.br.BretonWordTokenizer;
import org.languagetool.tokenizers.SRXSentenceTokenizer;
import org.languagetool.tokenizers.SentenceTokenizer;

/** 
 * @author Curon Wyn Davies
 */
public class Welsh extends Language {

  private SentenceTokenizer sentenceTokenizer;
  private Tagger tagger;

  @Override
  public SentenceTokenizer getSentenceTokenizer() {
    if (sentenceTokenizer == null) {
      sentenceTokenizer = new SRXSentenceTokenizer(this);
    }
    return sentenceTokenizer;
  }

/*  @Override
  public Tokenizer getWordTokenizer() {
    if (wordTokenizer == null) {
      wordTokenizer = new BretonWordTokenizer();
    }
    return wordTokenizer;
  }*/

  @Override
  public String getName() {
    return "Welsh";
  }

  @Override
  public String getShortName() {
    return "cy";
  }

  @Override
  public String[] getCountries() {
    return new String[] {"GB"};
  }
  
  @Override
  public Tagger getTagger() {
    if (tagger == null) {
      tagger = new DemoTagger();
    }
    return tagger;
  }

/*  @Override
  public Disambiguator getDisambiguator() {
    if (disambiguator == null) {
      disambiguator = new XmlRuleDisambiguator(new Breton());
    }
    return disambiguator;
  }*/

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] {
        new Contributor("Curon Wyn Davies")
    };
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages) throws IOException {
    return Arrays.asList(
            new CommaWhitespaceRule(messages),
            new DoublePunctuationRule(messages),
            new GenericUnpairedBracketsRule(messages),
 //           new MorfologikBretonSpellerRule(messages, this),
            new UppercaseSentenceStartRule(messages, this),
            new WordRepeatRule(messages, this),
            new MultipleWhitespaceRule(messages, this)//,
 //           new SentenceWhitespaceRule(messages)//,
 //           new TopoReplaceRule(messages)
    );
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }

}
