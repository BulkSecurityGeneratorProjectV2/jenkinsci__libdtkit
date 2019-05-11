/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2010, Thales Corporate Services SAS, Gregory Boissinot
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.lib.dtkit.type;

import hudson.ExtensionList;
import hudson.model.Describable;
import jenkins.model.Jenkins;
import org.jenkinsci.lib.dtkit.descriptor.ViolationsTypeDescriptor;
import org.jenkinsci.lib.dtkit.model.InputMetric;

@SuppressWarnings("serial")
public abstract class ViolationsType extends MetricsType implements Describable<ViolationsType> {


    protected ViolationsType(String pattern, boolean skipNoTestFiles, boolean failIfNotNew, boolean deleteOutputFiles, boolean stopProcessingIfError) {
        super(pattern, skipNoTestFiles, failIfNotNew, deleteOutputFiles, stopProcessingIfError);
    }

    protected ViolationsType(String pattern, boolean failIfNotNew, boolean deleteOutputFiles, boolean stopProcessingIfError) {
        super(pattern, failIfNotNew, deleteOutputFiles, stopProcessingIfError);
    }

    protected ViolationsType(String pattern, boolean failIfNotNew, boolean deleteOutputFiles) {
        super(pattern, failIfNotNew, deleteOutputFiles);
    }

    protected ViolationsType(String pattern) {
        super(pattern);
    }

    public static ExtensionList<ViolationsType> all() {
        return Jenkins.get().getExtensionList(ViolationsType.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ViolationsTypeDescriptor<? extends ViolationsType> getDescriptor() {
        return (ViolationsTypeDescriptor<? extends ViolationsType>) Jenkins.get().getDescriptor(getClass());
    }

    @Override
    public InputMetric getInputMetric() {
        return getDescriptor().getInputMetric();
    }
}
