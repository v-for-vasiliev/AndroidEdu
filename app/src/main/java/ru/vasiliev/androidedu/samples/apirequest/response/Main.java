package ru.vasiliev.androidedu.samples.apirequest.response;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("humidity")
    private Long mHumidity;

    @SerializedName("pressure")
    private Long mPressure;

    @SerializedName("temp")
    private Double mTemp;

    @SerializedName("temp_max")
    private Double mTempMax;

    @SerializedName("temp_min")
    private Double mTempMin;

    public Long getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Long humidity) {
        mHumidity = humidity;
    }

    public Long getPressure() {
        return mPressure;
    }

    public void setPressure(Long pressure) {
        mPressure = pressure;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public Double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(Double tempMax) {
        mTempMax = tempMax;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(Double tempMin) {
        mTempMin = tempMin;
    }

}
