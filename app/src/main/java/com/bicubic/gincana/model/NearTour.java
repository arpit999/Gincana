package com.bicubic.gincana.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 07-Dec-16.
 */

public class NearTour {

    /**
     * response : {"tourData":[{"TourID":"5","sLatitude":"23.0124","sLongitude":"72.5228","sCity":"ahmedabad","sTourName":"titanium city center ahmedabad","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","sShortDescription":"ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf","distance":"You are 5.11km away"},{"TourID":"3","sLatitude":"19.4362","sLongitude":"99.1373","sCity":"Mexico","sTourName":"Centro Histórico","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","sShortDescription":"The historic center of Mexico City (Spanish: Centro Histórico de la Ciudad de México), also known as the Centro or Centro Histórico, is the central neighborhood in Mexico City, Mexico, focused on Zócalo or main plaza and extending in all directions for a","distance":"You are 2,782.27km away"},{"TourID":"2","sLatitude":"19.4358","sLongitude":"99.1441","sCity":"Mexico City","sTourName":"Alameda Central","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14793063953.jpg","sShortDescription":"Alameda Central is a public municipal park in downtown Mexico City, adjacent to the Palacio de Bellas Artes, between Juarez Avenue and Hidalgo Avenue.","distance":"You are 2,782.98km away"}],"numoftour":3,"result":true,"errorCode":0}
     */


    @SerializedName("response")
    private ResponseBean response;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {

        @Override
        public String toString() {
            return "ResponseBean{" +
                    "numoftour=" + numoftour +
                    ", result=" + result +
                    ", errorCode=" + errorCode +
                    ", tourData=" + tourData +
                    '}';
        }

        /**
         * tourData : [{"TourID":"5","sLatitude":"23.0124","sLongitude":"72.5228","sCity":"ahmedabad","sTourName":"titanium city center ahmedabad","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","sShortDescription":"ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf","distance":"You are 5.11km away"},{"TourID":"3","sLatitude":"19.4362","sLongitude":"99.1373","sCity":"Mexico","sTourName":"Centro Histórico","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","sShortDescription":"The historic center of Mexico City (Spanish: Centro Histórico de la Ciudad de México), also known as the Centro or Centro Histórico, is the central neighborhood in Mexico City, Mexico, focused on Zócalo or main plaza and extending in all directions for a","distance":"You are 2,782.27km away"},{"TourID":"2","sLatitude":"19.4358","sLongitude":"99.1441","sCity":"Mexico City","sTourName":"Alameda Central","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14793063953.jpg","sShortDescription":"Alameda Central is a public municipal park in downtown Mexico City, adjacent to the Palacio de Bellas Artes, between Juarez Avenue and Hidalgo Avenue.","distance":"You are 2,782.98km away"}]
         * numoftour : 3
         * result : true
         * errorCode : 0
         */

        @SerializedName("numoftour")
        private int numoftour;
        @SerializedName("result")
        private boolean result;
        @SerializedName("errorCode")
        private int errorCode;
        @SerializedName("tourData")
        private List<TourDataBean> tourData;

        public int getNumoftour() {
            return numoftour;
        }

        public void setNumoftour(int numoftour) {
            this.numoftour = numoftour;
        }

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public List<TourDataBean> getTourData() {
            return tourData;
        }

        public void setTourData(List<TourDataBean> tourData) {
            this.tourData = tourData;
        }

        public static class TourDataBean {
            /**
             * TourID : 5
             * sLatitude : 23.0124
             * sLongitude : 72.5228
             * sCity : ahmedabad
             * sTourName : titanium city center ahmedabad
             * iImageData : http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg
             * sShortDescription : ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf
             * distance : You are 5.11km away
             */

            @SerializedName("TourID")
            private String TourID;
            @SerializedName("sLatitude")
            private String sLatitude;
            @SerializedName("sLongitude")
            private String sLongitude;
            @SerializedName("sCity")
            private String sCity;
            @SerializedName("sTourName")
            private String sTourName;
            @SerializedName("iImageData")
            private String iImageData;
            @SerializedName("sShortDescription")
            private String sShortDescription;
            @SerializedName("distance")
            private String distance;

            public String getTourID() {
                return TourID;
            }

            public void setTourID(String TourID) {
                this.TourID = TourID;
            }

            public String getSLatitude() {
                return sLatitude;
            }

            public void setSLatitude(String sLatitude) {
                this.sLatitude = sLatitude;
            }

            public String getSLongitude() {
                return sLongitude;
            }

            public void setSLongitude(String sLongitude) {
                this.sLongitude = sLongitude;
            }

            public String getSCity() {
                return sCity;
            }

            public void setSCity(String sCity) {
                this.sCity = sCity;
            }

            public String getSTourName() {
                return sTourName;
            }

            public void setSTourName(String sTourName) {
                this.sTourName = sTourName;
            }

            public String getIImageData() {
                return iImageData;
            }

            public void setIImageData(String iImageData) {
                this.iImageData = iImageData;
            }

            public String getSShortDescription() {
                return sShortDescription;
            }

            public void setSShortDescription(String sShortDescription) {
                this.sShortDescription = sShortDescription;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }
    }
}
