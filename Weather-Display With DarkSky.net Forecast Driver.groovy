
Weather-Display With DarkSky.net Forecast Driver
chat_bubble_outline
more_vert

Matthew
arrow_drop_downAccounts
Dashboards
Devices
Apps
Settings
Advanced
codeApps Code
codeDrivers Code
System Events
Logs
Weather-Display With DarkSky.net Forecast DriverImport   HelpDeleteSave
        updateDataValue("illuminance", !lux ? "0" : lux.toString())
        updateDataValue("illuminated", String.format("%,4d", !lux ? 0 : lux).toString())
581
                s_cardinal = 'SW'; s_direction = 'Southwest'
582
            }else if(ds.currently.nearestStormBearing.toBigDecimal() < 258.75) {
583
                s_cardinal = 'WSW'; s_direction = 'West-Southwest'
584
            }else if(ds.currently.nearestStormBearing.toBigDecimal() < 281.25) {
585
                s_cardinal = 'W'; s_direction = 'West'
586
            }else if(ds.currently.nearestStormBearing.toBigDecimal() < 303.75) {
587
                s_cardinal = 'WNW'; s_direction = 'West-Northwest'
588
            }else if(ds.currently.nearestStormBearing.toBigDecimal() < 326.26) {
589
                s_cardinal = 'NW'; s_direction = 'Northwest'
590
            }else if(ds.currently.nearestStormBearing.toBigDecimal() < 348.75) {
591
                s_cardinal = 'NNW'; s_direction = 'North-Northwest'
592
            }else if(ds.currently.nearestStormBearing.toBigDecimal() >= 348.75) {
593
                s_cardinal = 'N'; s_direction = 'North'
594
            }
595
        }    
596
        updateDataValue("nearestStormCardinal", s_cardinal)
597
        updateDataValue("nearestStormDirection", s_direction)
598
        updateDataValue("nearestStormDistance", (!ds.currently.nearestStormDistance ? "9999.9" : (isDistanceMetric ? (Math.round(ds.currently.nearestStormDistance.toBigDecimal() * 1.609344 * 10) / 10) : (Math.round(ds.currently.nearestStormDistance.toBigDecimal() * 10) / 10)).toString()))
599
    }
600
    updateDataValue("ozone", (Math.round(ds.currently.ozone.toBigDecimal() * 10 ) / 10).toString())
601
// >>>>>>>>>> End Setup Forecast Variables <<<<<<<<<<
602
​
603
// <<<<<<<<<< Begin Process Only If Illumination from WD Is NOT Selected  >>>>>>>>>>
604
    if(sourceIllumination==false) {
605
        def (lux, bwn) = estimateLux(getDataValue("condition_code"), getDataValue("cloud"))
606
        updateDataValue("bwn", bwn)
607
        updateDataValue("illuminance", !lux ? "0" : lux.toString())
608
        updateDataValue("illuminated", String.format("%,4d", !lux ? 0 : lux).toString())
609
    }
610
// >>>>>>>>>> End Process Only If Illumination from WD Is NOT Selected  <<<<<<<<<<
611
    
612
// <<<<<<<<<< Begin Process Only If Ultraviolet Index from WD Is NOT Selected  >>>>>>>>>>                    
613
    if(sourceUV==false){    
614
        updateDataValue("ultravioletIndex", value: ds.currently.uvIndex.toBigDecimal().toString())
615
    }
616
// >>>>>>>>>> End Process Only If Ultraviolet Index from WD Is NOT Selected  <<<<<<<<<<
617
    
618
// <<<<<<<<<< Begin Process Only If feelsLike Index from WD Is NOT Selected  >>>>>>>>>>                        
619
    if(sourcefeelsLike==false){
620
        updateDataValue("feelsLike",  (isFahrenheit ? (Math.round(ds.currently.apparentTemperature.toBigDecimal() * 10) / 10) : (Math.round((ds.currently.apparentTemperature.toBigDecimal() - 32) / 1.8 * 10) / 10)).toString())
621
    }    
622
// >>>>>>>>>> End Process Only If feelsLike from WD Is NOT Selected  <<<<<<<<<<    
623
​
624
// <<<<<<<<<< Begin Icon Processing  >>>>>>>>>>    
625
    if(sourceImg==false){ // 'Alternative' Icons selected
626
        imgName = (getDataValue("iconType")== 'true' ? getImgName(getDataValue("condition_code")) : getImgName(getDataValue("forecast_code")))
627
        sendEventPublish(name: "condition_icon", value: '<img src=' + imgName + '>')
628
        sendEventPublish(name: "condition_iconWithText", value: "<img src=" + imgName + "><br>" + (getDataValue("iconType")== 'true' ? getDataValue("condition_text") : getDataValue("forecast_text")))
629
        sendEventPublish(name: "condition_icon_url", value: imgName)
630
        updateDataValue("condition_icon_url", imgName)
631
        sendEventPublish(name: "condition_icon_only", value: imgName.split("/")[-1].replaceFirst("\\?raw=true",""))
632
    } else if(sourceImg==true) { // 'Standard Icons selected
633
        sendEventPublish(name: "condition_icon", value: '<img src=https://icons.wxug.com/i/c/a/' + (getDataValue("iconType")== 'true' ? getDataValue("condition_code") : getDataValue("forecast_code")) + '.gif>')
634
        sendEventPublish(name: "condition_iconWithText", value: '<img src=https://icons.wxug.com/i/c/a/' + (getDataValue("iconType")== 'true' ? getDataValue("condition_code") : getDataValue("forecast_code")) + '.gif><br>' + (getDataValue("iconType")== 'true' ? getDataValue("condition_text") : getDataValue("forecast_text")))
635
        sendEventPublish(name: "condition_icon_url", value: 'https://icons.wxug.com/i/c/a/' + (getDataValue("iconType")== 'true' ? getDataValue("condition_code") : getDataValue("forecast_code")) +'.gif')
636
        updateDataValue("condition_icon_url", 'https://icons.wxug.com/i/c/a/' + (getDataValue("iconType")== 'true' ? getDataValue("condition_code") : getDataValue("forecast_code")) +'.gif')
637
        sendEventPublish(name: "condition_icon_only", value: (getDataValue("iconType")== 'true' ? getDataValue("condition_code") : getDataValue("forecast_code")) +'.gif')
638
    }
639
// >>>>>>>>>> End Icon Processing <<<<<<<<<<    
640
    if(getDataValue("forecastPoll") == "false"){
Location: Superior, CO
Terms of Service
Documentation
Community
Support
Copyright 2019 Hubitat, Inc.
