import ratpack.groovy.sql.SqlModule
import ratpack.hikari.HikariModule
import ratpack.hyunlabs.KPIModule
import ratpack.hyunlabs.KPIService

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {

 bindings {
     add new HikariModule([URL: "jdbc:mysql://localhost/db", username: 'user', password: 'pass'], "com.mysql.jdbc.jdbc2.optional.MysqlDataSource")
//     add new HikariModule([URL: "jdbc:h2:mem:dev;INIT=CREATE SCHEMA IF NOT EXISTS DEV"], "org.h2.jdbcx.JdbcDataSource")
     add new SqlModule()
     add new KPIModule()
 }

  handlers {
    get { KPIService kpiService ->
      render groovyTemplate("index.html", title: "My Ratpack App", list: kpiService.getKpi('hi'))
    }
        
    assets "public"
  }
}
