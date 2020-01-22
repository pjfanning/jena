/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.datatypes.xsd.impl;

import org.apache.jena.datatypes.BaseDatatype ;
import org.apache.jena.datatypes.RDFDatatype ;
import org.apache.jena.graph.impl.LiteralLabel ;

/** rdf:json.
 * This only implements syntactic equality, not value equality.    
 */

public class RDFjson extends BaseDatatype implements RDFDatatype {
    /** Singleton instance */
    // Include the string for the RDF namespace, not use RDF.getURI(), to avoid an initializer circularity
    public static final RDFDatatype rdfJSON = new RDFjson("http://www.w3.org/1999/02/22-rdf-syntax-ns#JSON");
    
    /**
     * Private constructor.
     */
    private RDFjson(String uri) {
        super(uri);
    }

    /**
     * Compares two instances of values of the given datatype. 
     */
    @Override
    public boolean isEqual(LiteralLabel value1, LiteralLabel value2) {
        return isEqualByTerm(value1, value2) ;
    }
    
    @Override
    public Object parse(String lexicalForm) { return lexicalForm ; }
    
    @Override
    public String unparse(Object value) { return value.toString(); }
}

