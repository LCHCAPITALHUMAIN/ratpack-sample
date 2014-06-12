package ratpack.hyunlabs

import groovy.transform.CompileStatic

@CompileStatic
public interface KPIService {
    List getKpi(String key)
}