/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.mutationtest.instrument;

import java.io.IOException;
import java.io.Writer;

import org.apache.bcel.classfile.JavaClass;

import com.reeltwo.jumble.mutation.Mutater;

public class DefaultReporter implements Reporter {

  private final Writer w;

  DefaultReporter(final Writer w) {
    this.w = w;
  }

  public void report(final int i, final boolean mutationDetected,
      final JavaClass mutatedClass, final Mutater m, final String className)
      throws IOException {
    this.w.write("" + i + "=" + mutationDetected + ","
        + mutatedClass.getClassName() + "," + mutatedClass.getFileName() + ","
        + m.getModification() + "," + m.getMutatedMethodName(className) + "\n");

  }

  public void describe(final int i, final int numberOfTests,
      final JavaClass mutatedClass, final Mutater m, final String className)
      throws IOException {
    this.w.write("DESC=," + i + "," + numberOfTests + ","
        + mutatedClass.getClassName() + "," + mutatedClass.getFileName() + ","
        + m.getModification() + "," + m.getMutatedMethodName(className) + "\n");
  }

  public void report(final int i, final boolean mutationDetected)
      throws IOException {
    this.w.write("REP=," + i + "," + mutationDetected + "\n");
  }

}
