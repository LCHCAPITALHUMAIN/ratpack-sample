import groovy.sql.Sql
import ratpack.groovy.sql.SqlModule
import ratpack.hikari.HikariModule
import ratpack.hyunlabs.KPIModule
import ratpack.hyunlabs.KPIService

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {

 bindings {
     add new SqlModule(),
             new HikariModule('com.mysql.jdbc.jdbc2.optional.MysqlDataSource', URL: "jdbc:mysql://localhost/db", user: 'user', password: 'pass')
//     add new HikariModule('org.h2.jdbcx.JdbcDataSource', URL: "jdbc:h2:mem:dev;INIT=CREATE SCHEMA IF NOT EXISTS DEV")

     add new KPIModule()
 }

  handlers {
    get { KPIService kpiService ->
        def list = kpiService.getKpi('table_name')
      render groovyTemplate("index.html", title: "KPI Dashboard", list: list)
    }

    get("db") { Sql sql ->
      def schemas = sql.rows("show schemas")
      render schemas?.join(', ')
    }

    assets "public"
  }
}
