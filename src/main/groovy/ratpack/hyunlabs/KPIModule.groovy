package ratpack.hyunlabs

import com.google.inject.AbstractModule
import com.google.inject.Scopes

/**
 * Created by root on 6/11/2014.
 */
class KPIModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(KPIService).to(BrandRateKPI).in(Scopes.SINGLETON)
    }
}
