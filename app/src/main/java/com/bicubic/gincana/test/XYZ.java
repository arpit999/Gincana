package com.bicubic.gincana.test;

import java.util.List;

/**
 * Created by admin on 09-Dec-16.
 */

public class XYZ {


    /**
     * response : {"result":true,"errorCode":0,"errorDescription":"Success","tourData":{"TourID":"5","sTourName":"titanium city center ahmedabad","sShortDescription":"ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf","sLongDescription":"dsd dsd ds dsd dsd d sdsd ds dsd sds dd","sCity":"ahmedabad","sLatitude":"23.0124","sLongitude":"72.5228","sGoalLat":"-2.09","sGoalLong":"12.5228","sVersion":"1","dDate":"2016-11-29 00:41:32","status":"APPROVED","iTourImagesID":"18","iTourID":"5","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","bIsDefault":"1","dDateTime":"2016-11-29 13:11:49"},"tourCountData":{"total_image":"4","total_coin":"12","total_diamond":"1","total_clues":"3","total_checkpoint":"1"},"TourAllImageData":[{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405310background_menu@2x.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405312background_menu-568@2x.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405313background_menu@2x~ipad.jpeg","bIsDefault":"1"}],"img_result":true,"TourAllUserData":[],"u_result":false,"TourcoinsData":[{"sLatitude":"19.422655","sLongitude":"-99.161297","iTourPlaceID":"10"},{"sLatitude":"23.0135","sLongitude":"72.5228","iTourPlaceID":"12"},{"sLatitude":"23.0150","sLongitude":"72.5296","iTourPlaceID":"13"},{"sLatitude":"23.0150","sLongitude":"72.5245","iTourPlaceID":"14"},{"sLatitude":"23.0160","sLongitude":"72.5310","iTourPlaceID":"15"},{"sLatitude":"23.0115","sLongitude":"72.5228","iTourPlaceID":"16"},{"sLatitude":"23.0135","sLongitude":"72.5296","iTourPlaceID":"17"},{"sLatitude":"23.0115","sLongitude":"72.5200","iTourPlaceID":"18"},{"sLatitude":"23.0135","sLongitude":"72.5270","iTourPlaceID":"19"},{"sLatitude":"23.0135","sLongitude":"72.5260","iTourPlaceID":"20"},{"sLatitude":"23.0160","sLongitude":"72.5296","iTourPlaceID":"21"},{"sLatitude":"23.0170","sLongitude":"72.5310","iTourPlaceID":"22"}],"co_result":true,"TourDiamondData":[{"sLatitude":"23.011487","sLongitude":"72.525011","iTourPlaceID":"24","sPlaceImage":"http://www.trialme.in/Ginicana/images/places/1481007650-place.png","sPlaceDescription":"dd d dh hffh idufhfhf hf hfhd fhf hdfhufh ffdufh fhdfu dfhd fhd fhdfhdufduf hfhdfhd fhdfhdf dfhdufd ffdufh fhdufd ffhduf ufufh"}],"di_result":true,"TourCheckpointData":[{"sLatitude":"23.0225","sLongitude":"72.5714","iTourPlaceID":"23"}],"chk_result":true,"TourClueData":[{"sClues":"clue1"},{"sClues":"clue2"},{"sClues":"clue3"}],"clu_result":true}
     */

    private ResponseBean response;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * result : true
         * errorCode : 0
         * errorDescription : Success
         * tourData : {"TourID":"5","sTourName":"titanium city center ahmedabad","sShortDescription":"ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf","sLongDescription":"dsd dsd ds dsd dsd d sdsd ds dsd sds dd","sCity":"ahmedabad","sLatitude":"23.0124","sLongitude":"72.5228","sGoalLat":"-2.09","sGoalLong":"12.5228","sVersion":"1","dDate":"2016-11-29 00:41:32","status":"APPROVED","iTourImagesID":"18","iTourID":"5","iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","bIsDefault":"1","dDateTime":"2016-11-29 13:11:49"}
         * tourCountData : {"total_image":"4","total_coin":"12","total_diamond":"1","total_clues":"3","total_checkpoint":"1"}
         * TourAllImageData : [{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405310background_menu@2x.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405312background_menu-568@2x.jpeg","bIsDefault":"1"},{"iImageData":"http://www.trialme.in/Ginicana/images/tour-images/1480405313background_menu@2x~ipad.jpeg","bIsDefault":"1"}]
         * img_result : true
         * TourAllUserData : []
         * u_result : false
         * TourcoinsData : [{"sLatitude":"19.422655","sLongitude":"-99.161297","iTourPlaceID":"10"},{"sLatitude":"23.0135","sLongitude":"72.5228","iTourPlaceID":"12"},{"sLatitude":"23.0150","sLongitude":"72.5296","iTourPlaceID":"13"},{"sLatitude":"23.0150","sLongitude":"72.5245","iTourPlaceID":"14"},{"sLatitude":"23.0160","sLongitude":"72.5310","iTourPlaceID":"15"},{"sLatitude":"23.0115","sLongitude":"72.5228","iTourPlaceID":"16"},{"sLatitude":"23.0135","sLongitude":"72.5296","iTourPlaceID":"17"},{"sLatitude":"23.0115","sLongitude":"72.5200","iTourPlaceID":"18"},{"sLatitude":"23.0135","sLongitude":"72.5270","iTourPlaceID":"19"},{"sLatitude":"23.0135","sLongitude":"72.5260","iTourPlaceID":"20"},{"sLatitude":"23.0160","sLongitude":"72.5296","iTourPlaceID":"21"},{"sLatitude":"23.0170","sLongitude":"72.5310","iTourPlaceID":"22"}]
         * co_result : true
         * TourDiamondData : [{"sLatitude":"23.011487","sLongitude":"72.525011","iTourPlaceID":"24","sPlaceImage":"http://www.trialme.in/Ginicana/images/places/1481007650-place.png","sPlaceDescription":"dd d dh hffh idufhfhf hf hfhd fhf hdfhufh ffdufh fhdfu dfhd fhd fhdfhdufduf hfhdfhd fhdfhdf dfhdufd ffdufh fhdufd ffhduf ufufh"}]
         * di_result : true
         * TourCheckpointData : [{"sLatitude":"23.0225","sLongitude":"72.5714","iTourPlaceID":"23"}]
         * chk_result : true
         * TourClueData : [{"sClues":"clue1"},{"sClues":"clue2"},{"sClues":"clue3"}]
         * clu_result : true
         */

        private boolean result;
        private int errorCode;
        private String errorDescription;
        private TourDataBean tourData;
        private TourCountDataBean tourCountData;
        private boolean img_result;
        private boolean u_result;
        private boolean co_result;
        private boolean di_result;
        private boolean chk_result;
        private boolean clu_result;
        private List<TourAllImageDataBean> TourAllImageData;
        private List<?> TourAllUserData;
        private List<TourcoinsDataBean> TourcoinsData;
        private List<TourDiamondDataBean> TourDiamondData;
        private List<TourCheckpointDataBean> TourCheckpointData;
        private List<TourClueDataBean> TourClueData;

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

        public boolean isImg_result() {
            return img_result;
        }

        public void setImg_result(boolean img_result) {
            this.img_result = img_result;
        }

        public boolean isU_result() {
            return u_result;
        }

        public void setU_result(boolean u_result) {
            this.u_result = u_result;
        }

        public boolean isCo_result() {
            return co_result;
        }

        public void setCo_result(boolean co_result) {
            this.co_result = co_result;
        }

        public boolean isDi_result() {
            return di_result;
        }

        public void setDi_result(boolean di_result) {
            this.di_result = di_result;
        }

        public boolean isChk_result() {
            return chk_result;
        }

        public void setChk_result(boolean chk_result) {
            this.chk_result = chk_result;
        }

        public boolean isClu_result() {
            return clu_result;
        }

        public void setClu_result(boolean clu_result) {
            this.clu_result = clu_result;
        }

        public List<TourAllImageDataBean> getTourAllImageData() {
            return TourAllImageData;
        }

        public void setTourAllImageData(List<TourAllImageDataBean> TourAllImageData) {
            this.TourAllImageData = TourAllImageData;
        }

        public List<?> getTourAllUserData() {
            return TourAllUserData;
        }

        public void setTourAllUserData(List<?> TourAllUserData) {
            this.TourAllUserData = TourAllUserData;
        }

        public List<TourcoinsDataBean> getTourcoinsData() {
            return TourcoinsData;
        }

        public void setTourcoinsData(List<TourcoinsDataBean> TourcoinsData) {
            this.TourcoinsData = TourcoinsData;
        }

        public List<TourDiamondDataBean> getTourDiamondData() {
            return TourDiamondData;
        }

        public void setTourDiamondData(List<TourDiamondDataBean> TourDiamondData) {
            this.TourDiamondData = TourDiamondData;
        }

        public List<TourCheckpointDataBean> getTourCheckpointData() {
            return TourCheckpointData;
        }

        public void setTourCheckpointData(List<TourCheckpointDataBean> TourCheckpointData) {
            this.TourCheckpointData = TourCheckpointData;
        }

        public List<TourClueDataBean> getTourClueData() {
            return TourClueData;
        }

        public void setTourClueData(List<TourClueDataBean> TourClueData) {
            this.TourClueData = TourClueData;
        }

        public static class TourDataBean {
            /**
             * TourID : 5
             * sTourName : titanium city center ahmedabad
             * sShortDescription : ffjk fdjf fdjf fd f jkdf fjdf fdf f fhfjd fj jfjfjdhfhfhfdf f fjhf
             * sLongDescription : dsd dsd ds dsd dsd d sdsd ds dsd sds dd
             * sCity : ahmedabad
             * sLatitude : 23.0124
             * sLongitude : 72.5228
             * sGoalLat : -2.09
             * sGoalLong : 12.5228
             * sVersion : 1
             * dDate : 2016-11-29 00:41:32
             * status : APPROVED
             * iTourImagesID : 18
             * iTourID : 5
             * iImageData : http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg
             * bIsDefault : 1
             * dDateTime : 2016-11-29 13:11:49
             */

            private String TourID;
            private String sTourName;
            private String sShortDescription;
            private String sLongDescription;
            private String sCity;
            private String sLatitude;
            private String sLongitude;
            private String sGoalLat;
            private String sGoalLong;
            private String sVersion;
            private String dDate;
            private String status;
            private String iTourImagesID;
            private String iTourID;
            private String iImageData;
            private String bIsDefault;
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

            public String getSGoalLat() {
                return sGoalLat;
            }

            public void setSGoalLat(String sGoalLat) {
                this.sGoalLat = sGoalLat;
            }

            public String getSGoalLong() {
                return sGoalLong;
            }

            public void setSGoalLong(String sGoalLong) {
                this.sGoalLong = sGoalLong;
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
        }

        public static class TourCountDataBean {
            /**
             * total_image : 4
             * total_coin : 12
             * total_diamond : 1
             * total_clues : 3
             * total_checkpoint : 1
             */

            private String total_image;
            private String total_coin;
            private String total_diamond;
            private String total_clues;
            private String total_checkpoint;

            public String getTotal_image() {
                return total_image;
            }

            public void setTotal_image(String total_image) {
                this.total_image = total_image;
            }

            public String getTotal_coin() {
                return total_coin;
            }

            public void setTotal_coin(String total_coin) {
                this.total_coin = total_coin;
            }

            public String getTotal_diamond() {
                return total_diamond;
            }

            public void setTotal_diamond(String total_diamond) {
                this.total_diamond = total_diamond;
            }

            public String getTotal_clues() {
                return total_clues;
            }

            public void setTotal_clues(String total_clues) {
                this.total_clues = total_clues;
            }

            public String getTotal_checkpoint() {
                return total_checkpoint;
            }

            public void setTotal_checkpoint(String total_checkpoint) {
                this.total_checkpoint = total_checkpoint;
            }
        }

        public static class TourAllImageDataBean {
            /**
             * iImageData : http://www.trialme.in/Ginicana/images/tour-images/1480405309background_menu.jpeg
             * bIsDefault : 1
             */

            private String iImageData;
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
        }

        public static class TourcoinsDataBean {
            /**
             * sLatitude : 19.422655
             * sLongitude : -99.161297
             * iTourPlaceID : 10
             */

            private String sLatitude;
            private String sLongitude;
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
        }

        public static class TourDiamondDataBean {
            /**
             * sLatitude : 23.011487
             * sLongitude : 72.525011
             * iTourPlaceID : 24
             * sPlaceImage : http://www.trialme.in/Ginicana/images/places/1481007650-place.png
             * sPlaceDescription : dd d dh hffh idufhfhf hf hfhd fhf hdfhufh ffdufh fhdfu dfhd fhd fhdfhdufduf hfhdfhd fhdfhdf dfhdufd ffdufh fhdufd ffhduf ufufh
             */

            private String sLatitude;
            private String sLongitude;
            private String iTourPlaceID;
            private String sPlaceImage;
            private String sPlaceDescription;

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

            public String getSPlaceImage() {
                return sPlaceImage;
            }

            public void setSPlaceImage(String sPlaceImage) {
                this.sPlaceImage = sPlaceImage;
            }

            public String getSPlaceDescription() {
                return sPlaceDescription;
            }

            public void setSPlaceDescription(String sPlaceDescription) {
                this.sPlaceDescription = sPlaceDescription;
            }
        }

        public static class TourCheckpointDataBean {
            /**
             * sLatitude : 23.0225
             * sLongitude : 72.5714
             * iTourPlaceID : 23
             */

            private String sLatitude;
            private String sLongitude;
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
        }

        public static class TourClueDataBean {
            /**
             * sClues : clue1
             */

            private String sClues;

            public String getSClues() {
                return sClues;
            }

            public void setSClues(String sClues) {
                this.sClues = sClues;
            }
        }
    }
}
