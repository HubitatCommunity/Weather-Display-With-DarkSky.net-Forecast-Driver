Weather-Display With DarkSky.net Forecast Driver Copyright 2019 @Matthew (Scottma61)

Hubitat Community Forum discussion is here: https://community.hubitat.com/t/release-weather-display-with-darksky-net-forecast-driver/22613

Many people contributed to the creation of this driver. Significant contributors include:

@Cobra who adapted it from @mattw01's work and I thank them for that!
@bangali for his original APIXU.COM base code that much of the early versions of this driver was adapted from.
@bangali for his the Sunrise-Sunset.org code used to calculate illuminance/lux and the more recent adaptations of that code from @csteele in his continuation driver 'wx-ApiXU'.
@csteele (and prior versions from @bangali) for the attribute selection code.
@csteele for his examples on how to convert to asyncHttp calls to reduce Hub resource utilization.
@bangali also contributed the icon work from https://github.com/jebbett for new cooler 'Alternative' weather icons with icons courtesy of https://www.deviantart.com/vclouds/art/VClouds-Weather-Icons-179152045. - 'waynedgrant' for his json webservice that make the weather station data available to the driver.
In addition to all the cloned code from the Hubitat community, I have heavily modified/created new code myself @Matthew (Scottma61) with lots of help from the Hubitat community. If you believe you should have been acknowledged or received attribution for a code contribution, I will happily do so. While I compiled and orchestrated the driver, very little is actually original work of mine.

This driver is free to use. I do not accept donations. Please feel free to contribute to those mentioned here if you like this work, as it would not have been possible without them.

REQUIREMENTS: You MUST have a Personal Weather Station (PWS) and use Weather-Display software to *
capture that weather data from your network or a web server. If you do not meet this requirement *
then this driver will not work for you. This uses the Weather-Display data files from a webserver *
you specify in the driver preferences. I used waynedgrant's work to make those data files available *
in JSON format (https://github.com/waynedgrant/json-webservice-wdlive). *
This driver is intended to pull data from data files on a web server created by Weather-Display software (http://www.weather-display.com). It will also supplement forecast data from Dark Sky (DS) (http://darksky.net). You will need your DarkSky API key to use the forecast from that sites, but the driver it will work without an external forecast source.

The driver uses the Weather-Display data as the primary current weather dataset. There are a few options you can select from like using your forecast source for illuminance/solar radiation/lux if you do not have those sensors. You can also select to use a base set of condition icons from the forecast source, or an 'alternative' (fancier) set. The base 'Standard' icon set will be from WeatherUnderground. You may choose the fancier 'Alternative' icon set if you use the Dark Sky.

The driver exposes both metric and imperial measurements for you to select from.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at:

   http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
