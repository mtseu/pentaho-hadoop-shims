/*******************************************************************************
*
* Pentaho Big Data
*
* Copyright (C) 2002-2014 by Pentaho : http://www.pentaho.com
*
*******************************************************************************
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
******************************************************************************/

package org.pentaho.hadoop.shim.emr32.delegating;

import org.pentaho.hadoop.shim.ShimVersion;
import org.pentaho.hadoop.shim.api.Configuration;
import org.pentaho.hadoop.shim.emr32.authorization.HadoopAuthorizationService;
import org.pentaho.hadoop.shim.emr32.authorization.HasHadoopAuthorizationService;
import org.pentaho.hadoop.shim.spi.SqoopShim;

public class DelegatingSqoopShim implements SqoopShim, HasHadoopAuthorizationService {
  private SqoopShim delegate;

  @Override
  public void setHadoopAuthorizationService( HadoopAuthorizationService hadoopAuthorizationService ) {
    delegate = hadoopAuthorizationService.getShim( SqoopShim.class );
  }

  @Override
  public int runTool( String[] args, Configuration c ) {
    return delegate.runTool( args, c );
  }

  @Override
  public ShimVersion getVersion() {
    return delegate.getVersion();
  }
}
