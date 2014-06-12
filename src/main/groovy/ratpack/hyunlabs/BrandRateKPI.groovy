package ratpack.hyunlabs

import groovy.sql.Sql
import groovy.transform.CompileStatic

import javax.inject.Inject
import java.sql.ResultSet

@CompileStatic
class BrandRateKPI implements KPIService {

    @Inject
    Sql broadleaf

    List getKpi(String key) {
        def list = []
//        broadleaf.eachRow("select date(date_created) as `date`, count(*) as `count` from aha_business_entity group by date(date_created)") { ResultSet row ->
        broadleaf.eachRow("select * from gd_cities") { ResultSet row ->
            list << row.toRowResult()
        }

        list
    }
}
