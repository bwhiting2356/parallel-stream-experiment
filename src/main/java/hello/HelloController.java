package hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    public final String secretKey = "d690010d316bb6f90068c2dffc84fce3";


    List<LatLng> coords = new ArrayList<LatLng>() {{
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
        add(new LatLng("37.8267", "-122.4233"));
        add(new LatLng("42.3601", "-71.058"));
    }};

    RestTemplate restTemplate = new RestTemplate();

    private String getForecastForLatLng(LatLng latLng) {
        WeatherForecast response = restTemplate.getForObject(String.format("https://api.darksky.net/forecast/d690010d316bb6f90068c2dffc84fce3/%s,%s", latLng.lat, latLng.lng), WeatherForecast.class);
        return response.currently.summary;

    }

    @RequestMapping("/")
    public List<String> index() {
        return coords.parallelStream()
                .map(latLng -> getForecastForLatLng(latLng))
                .collect(Collectors.toList());
    }
    
}
