package com.example.spring.jersey;

import com.example.spring.ipdatabase.IpToLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Component
@Path("/api")
public class LocationResource {

    private final IpToLocationService ipToLocationService;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public LocationResource(IpToLocationService ipToLocationService,
                            HttpServletRequest httpServletRequest) {
        this.ipToLocationService = ipToLocationService;
        this.httpServletRequest = httpServletRequest;
    }

    @GET
    @Path("/location")
    public String location() {
        return ipToLocationService.getCountryByIp(httpServletRequest.getRemoteAddr());
    }

    @POST
    @Path("/update")
    public void update() {
        ipToLocationService.updateDatabaseInfo();
    }
}
