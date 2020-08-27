package com.bicubic.gincana.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 08-Dec-16.
 */

public class TourDetail implements Parcelable {



    /**
     * response : {"result":true,"errorCode":0,"errorDescription":"Success","tourData":{"TourID":"3","sTourName":"Centro Histórico","sShortDescription":"The historic center of Mexico City (Spanish: Centro Histórico de la Ciudad de México), also known as the Centro or Centro Histórico, is the central neighborhood in Mexico City, Mexico, focused on Zócalo or main plaza and extending in all directions for a","sLongDescription":"This section of the capital has just over nine square km and occupies 668 blocks. It contains 9,000 buildings, 1,550 of which have been declared of historical importance. Most of these historic buildings were constructed between the 16th and 20th centuries. It is divided into two zones for preservation purposes. Zone A encompasses the pre-Hispanic city and its expansion from the Viceroy period until Independence. Zone B covers the areas all other constructions to the end of the 19th century that are considered indispensable to the preservation of the area&#39;s architectural and cultural heritage.\r\n\r\nThis is where the Spaniards began to build what is now modern Mexico City in the 16th century on the ruins of the conquered Tenochtitlan, capital of the Aztec Empire. As the center of the ancient Aztec Empire and the seat of power for the Spanish colony of New Spain, the Centro Historico contains most of the city&#39;s historic sites from both eras as well as a large number of museums. This has made it a World Heritage Site.\r\n\r\n \r\n\r\nWhat is now the historic downtown of Mexico City roughly correlates with the ancient Aztec city of Tenochtitlan, which was founded around 1325. During the prehispanic era, the city developed in a planned fashion, with streets and canals aligned with the cardinal directions, leading to orderly square blocks. The island that the city was founded on was divided into four calpullis or neighborhoods that were divided by the main north-south roads leading to Tepeyac and Iztapalapa respectively and the west-east road that lead to Tacuba and to a dike into the lake, respectively. The calpullis were named Cuepopan, Atzacualco, Moyotla and Zoquipan, which had subdivisions and a \"tecpan\" or district council each. The intersection of these roads was the center of the city and of the Aztec world. Here were the Templo Mayor, the palaces of the tlatoani or emperors, palaces of nobles such as the \"House of the Demons\" and the \"House of the Flowers\". Also located here were the two most renowned Aztec schools: the Telpuchcalli for secular studies and the Calmecac for priestly training. When the Spaniards arrived, the city had aqueducts built by Moctezuma Ilhuicamina and Ahuizotl as well as a large dike constructed to the east of the city.\r\n\r\nAfter the Spanish conquest, this design remained largely intact, mostly due to the efforts of Alonso Garcia Bravo, who supervised much of the rebuilding of the city. This reconstruction conserved many of the main thoroughfares such as Tenayuca, renamed Vallejo; Tlacopan, renamed México Tacuba, and Tepeyac, now called the Calzada de los Misterios. They also kept major divisions of the city adding Christian prefixes to the names such as San Juan Moyotla, Santa María Tlaquechiuacan, San Sebastián Atzacualco and San Pedro Teopan. In fact, most of the centro historicos is built with the rubble of the destroyed Aztec city.\r\n\r\nA number of people during this time, all Spaniards, accumulated vast wealth mostly through mining and commerce in the 17th and 18th centuries. This wealth is reflected in the various mansions scattered in the centro such as the Palace of Iturbide and Casa de Azulejos (House of Tiles). This house was built in the 16th century in Arab style but its namesake tiles were added in 1747 when the Count of the Valley of Orizaba ordered the Talavera tiles from Puebla.\r\n\r\nIn the early part of the 20th century, as a result of the Latin American posture of then-Minister of Public Education José Vasconcelos, many of the streets to the north and west of the Zocalo were renamed after Latin American countries.","sCity":"Mexico","sLatitude":"19.4362","sLongitude":"99.1373","sVersion":"2","dDate":"2016-11-17 07:56:46","status":"APPROVED","iTourImagesID":"15","iTourID":"3","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","bIsDefault":"1","dDateTime":"2016-11-25 18:28:31"},"tourCountData":{"total_image":"3","total_coin":"1","total_treasure":"0","total_checkpoint":"1"},"TourAllImageData":[{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14800787211470663476_104847821.jpg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14800787234.png","bIsDefault":"1"}],"img_result":true,"TourAllUserData":"No user data Found","u_result":false,"TourcoinsData":[{"sLatitude":"19.422655","sLongitude":"-99.161297","iTourPlaceID":"8"}],"co_result":true,"TourDiamondData":"No diamond Found","di_result":false,"TourCheckpointData":[{"sLatitude":"44.49","sLongitude":"20.28","iTourPlaceID":"4"}],"chk_result":true,"TourClueData":"No Clue Found","clu_result":false,"TourChallenge1Data":[],"TourChallenge2Data":[],"TourChallenge3Data":[],"TourChallenge4Data":[]}
     */

    @SerializedName("response")
    private ResponseBean response;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean implements Parcelable {

        /**
         * result : true
         * errorCode : 0
         * errorDescription : Success
         * tourData : {"TourID":"3","sTourName":"Centro Histórico","sShortDescription":"The historic center of Mexico City (Spanish: Centro Histórico de la Ciudad de México), also known as the Centro or Centro Histórico, is the central neighborhood in Mexico City, Mexico, focused on Zócalo or main plaza and extending in all directions for a","sLongDescription":"This section of the capital has just over nine square km and occupies 668 blocks. It contains 9,000 buildings, 1,550 of which have been declared of historical importance. Most of these historic buildings were constructed between the 16th and 20th centuries. It is divided into two zones for preservation purposes. Zone A encompasses the pre-Hispanic city and its expansion from the Viceroy period until Independence. Zone B covers the areas all other constructions to the end of the 19th century that are considered indispensable to the preservation of the area&#39;s architectural and cultural heritage.\r\n\r\nThis is where the Spaniards began to build what is now modern Mexico City in the 16th century on the ruins of the conquered Tenochtitlan, capital of the Aztec Empire. As the center of the ancient Aztec Empire and the seat of power for the Spanish colony of New Spain, the Centro Historico contains most of the city&#39;s historic sites from both eras as well as a large number of museums. This has made it a World Heritage Site.\r\n\r\n \r\n\r\nWhat is now the historic downtown of Mexico City roughly correlates with the ancient Aztec city of Tenochtitlan, which was founded around 1325. During the prehispanic era, the city developed in a planned fashion, with streets and canals aligned with the cardinal directions, leading to orderly square blocks. The island that the city was founded on was divided into four calpullis or neighborhoods that were divided by the main north-south roads leading to Tepeyac and Iztapalapa respectively and the west-east road that lead to Tacuba and to a dike into the lake, respectively. The calpullis were named Cuepopan, Atzacualco, Moyotla and Zoquipan, which had subdivisions and a \"tecpan\" or district council each. The intersection of these roads was the center of the city and of the Aztec world. Here were the Templo Mayor, the palaces of the tlatoani or emperors, palaces of nobles such as the \"House of the Demons\" and the \"House of the Flowers\". Also located here were the two most renowned Aztec schools: the Telpuchcalli for secular studies and the Calmecac for priestly training. When the Spaniards arrived, the city had aqueducts built by Moctezuma Ilhuicamina and Ahuizotl as well as a large dike constructed to the east of the city.\r\n\r\nAfter the Spanish conquest, this design remained largely intact, mostly due to the efforts of Alonso Garcia Bravo, who supervised much of the rebuilding of the city. This reconstruction conserved many of the main thoroughfares such as Tenayuca, renamed Vallejo; Tlacopan, renamed México Tacuba, and Tepeyac, now called the Calzada de los Misterios. They also kept major divisions of the city adding Christian prefixes to the names such as San Juan Moyotla, Santa María Tlaquechiuacan, San Sebastián Atzacualco and San Pedro Teopan. In fact, most of the centro historicos is built with the rubble of the destroyed Aztec city.\r\n\r\nA number of people during this time, all Spaniards, accumulated vast wealth mostly through mining and commerce in the 17th and 18th centuries. This wealth is reflected in the various mansions scattered in the centro such as the Palace of Iturbide and Casa de Azulejos (House of Tiles). This house was built in the 16th century in Arab style but its namesake tiles were added in 1747 when the Count of the Valley of Orizaba ordered the Talavera tiles from Puebla.\r\n\r\nIn the early part of the 20th century, as a result of the Latin American posture of then-Minister of Public Education José Vasconcelos, many of the streets to the north and west of the Zocalo were renamed after Latin American countries.","sCity":"Mexico","sLatitude":"19.4362","sLongitude":"99.1373","sVersion":"2","dDate":"2016-11-17 07:56:46","status":"APPROVED","iTourImagesID":"15","iTourID":"3","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","bIsDefault":"1","dDateTime":"2016-11-25 18:28:31"}
         * tourCountData : {"total_image":"3","total_coin":"1","total_treasure":"0","total_checkpoint":"1"}
         * TourAllImageData : [{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14800787211470663476_104847821.jpg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/14800787234.png","bIsDefault":"1"}]
         * img_result : true
         * TourAllUserData : No user data Found
         * u_result : false
         * TourcoinsData : [{"sLatitude":"19.422655","sLongitude":"-99.161297","iTourPlaceID":"8"}]
         * co_result : true
         * TourDiamondData : No diamond Found
         * di_result : false
         * TourCheckpointData : [{"sLatitude":"44.49","sLongitude":"20.28","iTourPlaceID":"4"}]
         * chk_result : true
         * TourClueData : No Clue Found
         * clu_result : false
         * TourChallenge1Data : []
         * TourChallenge2Data : []
         * TourChallenge3Data : []
         * TourChallenge4Data : []
         */

        @SerializedName("result")
        private boolean result;
        @SerializedName("errorCode")
        private int errorCode;
        @SerializedName("errorDescription")
        private String errorDescription;
        @SerializedName("tourData")
        private TourDataBean tourData;
        @SerializedName("tourCountData")
        private TourCountDataBean tourCountData;
        @SerializedName("img_result")
        private boolean imgResult;
        @SerializedName("TourAllUserData")
        private String TourAllUserData;
        @SerializedName("u_result")
        private boolean uResult;
        @SerializedName("co_result")
        private boolean coResult;
        @SerializedName("TourDiamondData")
        private String TourDiamondData;
        @SerializedName("di_result")
        private boolean diResult;
        @SerializedName("chk_result")
        private boolean chkResult;
        @SerializedName("TourClueData")
        private String TourClueData;
        @SerializedName("clu_result")
        private boolean cluResult;
        @SerializedName("TourAllImageData")
        private List<TourAllImageDataBean> TourAllImageData;
        @SerializedName("TourcoinsData")
        private List<TourcoinsDataBean> TourcoinsData;
        @SerializedName("TourCheckpointData")
        private List<TourCheckpointDataBean> TourCheckpointData;
        @SerializedName("TourChallenge1Data")
        private List<?> TourChallenge1Data;
        @SerializedName("TourChallenge2Data")
        private List<?> TourChallenge2Data;
        @SerializedName("TourChallenge3Data")
        private List<?> TourChallenge3Data;
        @SerializedName("TourChallenge4Data")
        private List<?> TourChallenge4Data;

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

        public String getErrorDescription() {
            return errorDescription;
        }

        public void setErrorDescription(String errorDescription) {
            this.errorDescription = errorDescription;
        }

        public TourDataBean getTourData() {
            return tourData;
        }

        public void setTourData(TourDataBean tourData) {
            this.tourData = tourData;
        }

        public TourCountDataBean getTourCountData() {
            return tourCountData;
        }

        public void setTourCountData(TourCountDataBean tourCountData) {
            this.tourCountData = tourCountData;
        }

        public boolean isImgResult() {
            return imgResult;
        }

        public void setImgResult(boolean imgResult) {
            this.imgResult = imgResult;
        }

        public String getTourAllUserData() {
            return TourAllUserData;
        }

        public void setTourAllUserData(String TourAllUserData) {
            this.TourAllUserData = TourAllUserData;
        }

        public boolean isUResult() {
            return uResult;
        }

        public void setUResult(boolean uResult) {
            this.uResult = uResult;
        }

        public boolean isCoResult() {
            return coResult;
        }

        public void setCoResult(boolean coResult) {
            this.coResult = coResult;
        }

        public String getTourDiamondData() {
            return TourDiamondData;
        }

        public void setTourDiamondData(String TourDiamondData) {
            this.TourDiamondData = TourDiamondData;
        }

        public boolean isDiResult() {
            return diResult;
        }

        public void setDiResult(boolean diResult) {
            this.diResult = diResult;
        }

        public boolean isChkResult() {
            return chkResult;
        }

        public void setChkResult(boolean chkResult) {
            this.chkResult = chkResult;
        }

        public String getTourClueData() {
            return TourClueData;
        }

        public void setTourClueData(String TourClueData) {
            this.TourClueData = TourClueData;
        }

        public boolean isCluResult() {
            return cluResult;
        }

        public void setCluResult(boolean cluResult) {
            this.cluResult = cluResult;
        }

        public List<TourAllImageDataBean> getTourAllImageData() {
            return TourAllImageData;
        }

        public void setTourAllImageData(List<TourAllImageDataBean> TourAllImageData) {
            this.TourAllImageData = TourAllImageData;
        }

        public List<TourcoinsDataBean> getTourcoinsData() {
            return TourcoinsData;
        }

        public void setTourcoinsData(List<TourcoinsDataBean> TourcoinsData) {
            this.TourcoinsData = TourcoinsData;
        }

        public List<TourCheckpointDataBean> getTourCheckpointData() {
            return TourCheckpointData;
        }

        public void setTourCheckpointData(List<TourCheckpointDataBean> TourCheckpointData) {
            this.TourCheckpointData = TourCheckpointData;
        }

        public List<?> getTourChallenge1Data() {
            return TourChallenge1Data;
        }

        public void setTourChallenge1Data(List<?> TourChallenge1Data) {
            this.TourChallenge1Data = TourChallenge1Data;
        }

        public List<?> getTourChallenge2Data() {
            return TourChallenge2Data;
        }

        public void setTourChallenge2Data(List<?> TourChallenge2Data) {
            this.TourChallenge2Data = TourChallenge2Data;
        }

        public List<?> getTourChallenge3Data() {
            return TourChallenge3Data;
        }

        public void setTourChallenge3Data(List<?> TourChallenge3Data) {
            this.TourChallenge3Data = TourChallenge3Data;
        }

        public List<?> getTourChallenge4Data() {
            return TourChallenge4Data;
        }

        public void setTourChallenge4Data(List<?> TourChallenge4Data) {
            this.TourChallenge4Data = TourChallenge4Data;
        }

        public static class TourDataBean implements Parcelable {


            /**
             * TourID : 3
             * sTourName : Centro Histórico
             * sShortDescription : The historic center of Mexico City (Spanish: Centro Histórico de la Ciudad de México), also known as the Centro or Centro Histórico, is the central neighborhood in Mexico City, Mexico, focused on Zócalo or main plaza and extending in all directions for a
             * sLongDescription : This section of the capital has just over nine square km and occupies 668 blocks. It contains 9,000 buildings, 1,550 of which have been declared of historical importance. Most of these historic buildings were constructed between the 16th and 20th centuries. It is divided into two zones for preservation purposes. Zone A encompasses the pre-Hispanic city and its expansion from the Viceroy period until Independence. Zone B covers the areas all other constructions to the end of the 19th century that are considered indispensable to the preservation of the area&#39;s architectural and cultural heritage.

             This is where the Spaniards began to build what is now modern Mexico City in the 16th century on the ruins of the conquered Tenochtitlan, capital of the Aztec Empire. As the center of the ancient Aztec Empire and the seat of power for the Spanish colony of New Spain, the Centro Historico contains most of the city&#39;s historic sites from both eras as well as a large number of museums. This has made it a World Heritage Site.

              

             What is now the historic downtown of Mexico City roughly correlates with the ancient Aztec city of Tenochtitlan, which was founded around 1325. During the prehispanic era, the city developed in a planned fashion, with streets and canals aligned with the cardinal directions, leading to orderly square blocks. The island that the city was founded on was divided into four calpullis or neighborhoods that were divided by the main north-south roads leading to Tepeyac and Iztapalapa respectively and the west-east road that lead to Tacuba and to a dike into the lake, respectively. The calpullis were named Cuepopan, Atzacualco, Moyotla and Zoquipan, which had subdivisions and a "tecpan" or district council each. The intersection of these roads was the center of the city and of the Aztec world. Here were the Templo Mayor, the palaces of the tlatoani or emperors, palaces of nobles such as the "House of the Demons" and the "House of the Flowers". Also located here were the two most renowned Aztec schools: the Telpuchcalli for secular studies and the Calmecac for priestly training. When the Spaniards arrived, the city had aqueducts built by Moctezuma Ilhuicamina and Ahuizotl as well as a large dike constructed to the east of the city.

             After the Spanish conquest, this design remained largely intact, mostly due to the efforts of Alonso Garcia Bravo, who supervised much of the rebuilding of the city. This reconstruction conserved many of the main thoroughfares such as Tenayuca, renamed Vallejo; Tlacopan, renamed México Tacuba, and Tepeyac, now called the Calzada de los Misterios. They also kept major divisions of the city adding Christian prefixes to the names such as San Juan Moyotla, Santa María Tlaquechiuacan, San Sebastián Atzacualco and San Pedro Teopan. In fact, most of the centro historicos is built with the rubble of the destroyed Aztec city.

             A number of people during this time, all Spaniards, accumulated vast wealth mostly through mining and commerce in the 17th and 18th centuries. This wealth is reflected in the various mansions scattered in the centro such as the Palace of Iturbide and Casa de Azulejos (House of Tiles). This house was built in the 16th century in Arab style but its namesake tiles were added in 1747 when the Count of the Valley of Orizaba ordered the Talavera tiles from Puebla.

             In the early part of the 20th century, as a result of the Latin American posture of then-Minister of Public Education José Vasconcelos, many of the streets to the north and west of the Zocalo were renamed after Latin American countries.
             * sCity : Mexico
             * sLatitude : 19.4362
             * sLongitude : 99.1373
             * sVersion : 2
             * dDate : 2016-11-17 07:56:46
             * status : APPROVED
             * iTourImagesID : 15
             * iTourID : 3
             * iImageData : http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg
             * bIsDefault : 1
             * dDateTime : 2016-11-25 18:28:31
             */

            @SerializedName("TourID")
            private String TourID;
            @SerializedName("sTourName")
            private String sTourName;
            @SerializedName("sShortDescription")
            private String sShortDescription;
            @SerializedName("sLongDescription")
            private String sLongDescription;
            @SerializedName("sCity")
            private String sCity;
            @SerializedName("sLatitude")
            private String sLatitude;
            @SerializedName("sLongitude")
            private String sLongitude;
            @SerializedName("sVersion")
            private String sVersion;
            @SerializedName("dDate")
            private String dDate;
            @SerializedName("status")
            private String status;
            @SerializedName("iTourImagesID")
            private String iTourImagesID;
            @SerializedName("iTourID")
            private String iTourID;
            @SerializedName("iImageData")
            private String iImageData;
            @SerializedName("bIsDefault")
            private String bIsDefault;
            @SerializedName("dDateTime")
            private String dDateTime;

            public String getTourID() {
                return TourID;
            }

            public void setTourID(String TourID) {
                this.TourID = TourID;
            }

            public String getSTourName() {
                return sTourName;
            }

            public void setSTourName(String sTourName) {
                this.sTourName = sTourName;
            }

            public String getSShortDescription() {
                return sShortDescription;
            }

            public void setSShortDescription(String sShortDescription) {
                this.sShortDescription = sShortDescription;
            }

            public String getSLongDescription() {
                return sLongDescription;
            }

            public void setSLongDescription(String sLongDescription) {
                this.sLongDescription = sLongDescription;
            }

            public String getSCity() {
                return sCity;
            }

            public void setSCity(String sCity) {
                this.sCity = sCity;
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

            public String getSVersion() {
                return sVersion;
            }

            public void setSVersion(String sVersion) {
                this.sVersion = sVersion;
            }

            public String getDDate() {
                return dDate;
            }

            public void setDDate(String dDate) {
                this.dDate = dDate;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getITourImagesID() {
                return iTourImagesID;
            }

            public void setITourImagesID(String iTourImagesID) {
                this.iTourImagesID = iTourImagesID;
            }

            public String getITourID() {
                return iTourID;
            }

            public void setITourID(String iTourID) {
                this.iTourID = iTourID;
            }

            public String getIImageData() {
                return iImageData;
            }

            public void setIImageData(String iImageData) {
                this.iImageData = iImageData;
            }

            public String getBIsDefault() {
                return bIsDefault;
            }

            public void setBIsDefault(String bIsDefault) {
                this.bIsDefault = bIsDefault;
            }

            public String getDDateTime() {
                return dDateTime;
            }

            public void setDDateTime(String dDateTime) {
                this.dDateTime = dDateTime;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.TourID);
                dest.writeString(this.sTourName);
                dest.writeString(this.sShortDescription);
                dest.writeString(this.sLongDescription);
                dest.writeString(this.sCity);
                dest.writeString(this.sLatitude);
                dest.writeString(this.sLongitude);
                dest.writeString(this.sVersion);
                dest.writeString(this.dDate);
                dest.writeString(this.status);
                dest.writeString(this.iTourImagesID);
                dest.writeString(this.iTourID);
                dest.writeString(this.iImageData);
                dest.writeString(this.bIsDefault);
                dest.writeString(this.dDateTime);
            }

            public TourDataBean() {
            }

            protected TourDataBean(Parcel in) {
                this.TourID = in.readString();
                this.sTourName = in.readString();
                this.sShortDescription = in.readString();
                this.sLongDescription = in.readString();
                this.sCity = in.readString();
                this.sLatitude = in.readString();
                this.sLongitude = in.readString();
                this.sVersion = in.readString();
                this.dDate = in.readString();
                this.status = in.readString();
                this.iTourImagesID = in.readString();
                this.iTourID = in.readString();
                this.iImageData = in.readString();
                this.bIsDefault = in.readString();
                this.dDateTime = in.readString();
            }

            public static final Creator<TourDataBean> CREATOR = new Creator<TourDataBean>() {
                @Override
                public TourDataBean createFromParcel(Parcel source) {
                    return new TourDataBean(source);
                }

                @Override
                public TourDataBean[] newArray(int size) {
                    return new TourDataBean[size];
                }
            };
        }

        public static class TourCountDataBean implements Parcelable {

            /**
             * total_image : 3
             * total_coin : 1
             * total_treasure : 0
             * total_checkpoint : 1
             */

            @SerializedName("total_image")
            private String totalImage;
            @SerializedName("total_coin")
            private String totalCoin;
            @SerializedName("total_treasure")
            private String totalTreasure;
            @SerializedName("total_checkpoint")
            private String totalCheckpoint;

            public String getTotalImage() {
                return totalImage;
            }

            public void setTotalImage(String totalImage) {
                this.totalImage = totalImage;
            }

            public String getTotalCoin() {
                return totalCoin;
            }

            public void setTotalCoin(String totalCoin) {
                this.totalCoin = totalCoin;
            }

            public String getTotalTreasure() {
                return totalTreasure;
            }

            public void setTotalTreasure(String totalTreasure) {
                this.totalTreasure = totalTreasure;
            }

            public String getTotalCheckpoint() {
                return totalCheckpoint;
            }

            public void setTotalCheckpoint(String totalCheckpoint) {
                this.totalCheckpoint = totalCheckpoint;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.totalImage);
                dest.writeString(this.totalCoin);
                dest.writeString(this.totalTreasure);
                dest.writeString(this.totalCheckpoint);
            }

            public TourCountDataBean() {
            }

            protected TourCountDataBean(Parcel in) {
                this.totalImage = in.readString();
                this.totalCoin = in.readString();
                this.totalTreasure = in.readString();
                this.totalCheckpoint = in.readString();
            }

            public static final Creator<TourCountDataBean> CREATOR = new Creator<TourCountDataBean>() {
                @Override
                public TourCountDataBean createFromParcel(Parcel source) {
                    return new TourCountDataBean(source);
                }

                @Override
                public TourCountDataBean[] newArray(int size) {
                    return new TourCountDataBean[size];
                }
            };
        }

        public static class TourAllImageDataBean implements Parcelable {

            /**
             * iImageData : http://www.trialme.in/Ginicana/images/tour-images/148007871173d142e05d111e97de9e02f05b986731_laado-1.jpeg
             * bIsDefault : 1
             */

            @SerializedName("iImageData")
            private String iImageData;
            @SerializedName("bIsDefault")
            private String bIsDefault;

            public String getIImageData() {
                return iImageData;
            }

            public void setIImageData(String iImageData) {
                this.iImageData = iImageData;
            }

            public String getBIsDefault() {
                return bIsDefault;
            }

            public void setBIsDefault(String bIsDefault) {
                this.bIsDefault = bIsDefault;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.iImageData);
                dest.writeString(this.bIsDefault);
            }

            public TourAllImageDataBean() {
            }

            protected TourAllImageDataBean(Parcel in) {
                this.iImageData = in.readString();
                this.bIsDefault = in.readString();
            }

            public static final Creator<TourAllImageDataBean> CREATOR = new Creator<TourAllImageDataBean>() {
                @Override
                public TourAllImageDataBean createFromParcel(Parcel source) {
                    return new TourAllImageDataBean(source);
                }

                @Override
                public TourAllImageDataBean[] newArray(int size) {
                    return new TourAllImageDataBean[size];
                }
            };
        }

        public static class TourcoinsDataBean implements Parcelable {

            /**
             * sLatitude : 19.422655
             * sLongitude : -99.161297
             * iTourPlaceID : 8
             */

            @SerializedName("sLatitude")
            private String sLatitude;
            @SerializedName("sLongitude")
            private String sLongitude;
            @SerializedName("iTourPlaceID")
            private String iTourPlaceID;

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

            public String getITourPlaceID() {
                return iTourPlaceID;
            }

            public void setITourPlaceID(String iTourPlaceID) {
                this.iTourPlaceID = iTourPlaceID;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.sLatitude);
                dest.writeString(this.sLongitude);
                dest.writeString(this.iTourPlaceID);
            }

            public TourcoinsDataBean() {
            }

            protected TourcoinsDataBean(Parcel in) {
                this.sLatitude = in.readString();
                this.sLongitude = in.readString();
                this.iTourPlaceID = in.readString();
            }

            public static final Creator<TourcoinsDataBean> CREATOR = new Creator<TourcoinsDataBean>() {
                @Override
                public TourcoinsDataBean createFromParcel(Parcel source) {
                    return new TourcoinsDataBean(source);
                }

                @Override
                public TourcoinsDataBean[] newArray(int size) {
                    return new TourcoinsDataBean[size];
                }
            };
        }

        public static class TourCheckpointDataBean implements Parcelable {

            /**
             * sLatitude : 44.49
             * sLongitude : 20.28
             * iTourPlaceID : 4
             */

            @SerializedName("sLatitude")
            private String sLatitude;
            @SerializedName("sLongitude")
            private String sLongitude;
            @SerializedName("iTourPlaceID")
            private String iTourPlaceID;

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

            public String getITourPlaceID() {
                return iTourPlaceID;
            }

            public void setITourPlaceID(String iTourPlaceID) {
                this.iTourPlaceID = iTourPlaceID;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.sLatitude);
                dest.writeString(this.sLongitude);
                dest.writeString(this.iTourPlaceID);
            }

            public TourCheckpointDataBean() {
            }

            protected TourCheckpointDataBean(Parcel in) {
                this.sLatitude = in.readString();
                this.sLongitude = in.readString();
                this.iTourPlaceID = in.readString();
            }

            public static final Creator<TourCheckpointDataBean> CREATOR = new Creator<TourCheckpointDataBean>() {
                @Override
                public TourCheckpointDataBean createFromParcel(Parcel source) {
                    return new TourCheckpointDataBean(source);
                }

                @Override
                public TourCheckpointDataBean[] newArray(int size) {
                    return new TourCheckpointDataBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.result ? (byte) 1 : (byte) 0);
            dest.writeInt(this.errorCode);
            dest.writeString(this.errorDescription);
            dest.writeParcelable(this.tourData, flags);
            dest.writeParcelable(this.tourCountData, flags);
            dest.writeByte(this.imgResult ? (byte) 1 : (byte) 0);
            dest.writeString(this.TourAllUserData);
            dest.writeByte(this.uResult ? (byte) 1 : (byte) 0);
            dest.writeByte(this.coResult ? (byte) 1 : (byte) 0);
            dest.writeString(this.TourDiamondData);
            dest.writeByte(this.diResult ? (byte) 1 : (byte) 0);
            dest.writeByte(this.chkResult ? (byte) 1 : (byte) 0);
            dest.writeString(this.TourClueData);
            dest.writeByte(this.cluResult ? (byte) 1 : (byte) 0);
            dest.writeList(this.TourAllImageData);
            dest.writeList(this.TourcoinsData);
            dest.writeList(this.TourCheckpointData);
            dest.writeList(this.TourChallenge1Data);
            dest.writeList(this.TourChallenge2Data);
            dest.writeList(this.TourChallenge3Data);
            dest.writeList(this.TourChallenge4Data);
        }

        public ResponseBean() {
        }

        protected ResponseBean(Parcel in) {
            this.result = in.readByte() != 0;
            this.errorCode = in.readInt();
            this.errorDescription = in.readString();
            this.tourData = in.readParcelable(TourDataBean.class.getClassLoader());
            this.tourCountData = in.readParcelable(TourCountDataBean.class.getClassLoader());
            this.imgResult = in.readByte() != 0;
            this.TourAllUserData = in.readString();
            this.uResult = in.readByte() != 0;
            this.coResult = in.readByte() != 0;
            this.TourDiamondData = in.readString();
            this.diResult = in.readByte() != 0;
            this.chkResult = in.readByte() != 0;
            this.TourClueData = in.readString();
            this.cluResult = in.readByte() != 0;
            this.TourAllImageData = new ArrayList<TourAllImageDataBean>();
            in.readList(this.TourAllImageData, TourAllImageDataBean.class.getClassLoader());
            this.TourcoinsData = new ArrayList<TourcoinsDataBean>();
            in.readList(this.TourcoinsData, TourcoinsDataBean.class.getClassLoader());
            this.TourCheckpointData = new ArrayList<TourCheckpointDataBean>();
            in.readList(this.TourCheckpointData, TourCheckpointDataBean.class.getClassLoader());
           /* this.TourChallenge1Data = new ArrayList<?>();
            in.readList(this.TourChallenge1Data, ?.class.getClassLoader());
            this.TourChallenge2Data = new ArrayList<?>();
            in.readList(this.TourChallenge2Data, ?.class.getClassLoader());
            this.TourChallenge3Data = new ArrayList<?>();
            in.readList(this.TourChallenge3Data, ?.class.getClassLoader());
            this.TourChallenge4Data = new ArrayList<?>();
            in.readList(this.TourChallenge4Data, ?.class.getClassLoader());*/
        }

        public static final Creator<ResponseBean> CREATOR = new Creator<ResponseBean>() {
            @Override
            public ResponseBean createFromParcel(Parcel source) {
                return new ResponseBean(source);
            }

            @Override
            public ResponseBean[] newArray(int size) {
                return new ResponseBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.response, flags);
    }

    public TourDetail() {
    }

    protected TourDetail(Parcel in) {
        this.response = in.readParcelable(ResponseBean.class.getClassLoader());
    }

    public static final Creator<TourDetail> CREATOR = new Creator<TourDetail>() {
        @Override
        public TourDetail createFromParcel(Parcel source) {
            return new TourDetail(source);
        }

        @Override
        public TourDetail[] newArray(int size) {
            return new TourDetail[size];
        }
    };
}
