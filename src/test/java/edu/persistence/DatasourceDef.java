package edu.persistence;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

/**
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 * <p/>
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
@Stateless
@DataSourceDefinition(
        name = "java:app/jpa-introduction-ds",
        className = "org.postgresql.Driver",
        url = "jdbc:postgresql://localhost:5432/docker",
        user = "docker",
        password = "postgres"
)
public class DatasourceDef {
}
