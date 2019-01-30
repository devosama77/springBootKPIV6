package org.osama.kpi.model;



public class Cost {
    private String sizeOfTanker;
    private double fuelSurchargeRate;
//    @Pattern(regexp = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", message = "Invalid Number")
    private String distanceToBuyer="0.0";
//    @Pattern(regexp = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", message = "Invalid Number")
    private String distanceToMill="0.0";
//    @Pattern(regexp = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", message = "Invalid Number")
    private String distanceToBase="0.0";
    private String capacity="0.0";
    private String standByTime="0.0";
    private String deliveryTime="0.0";
    private String salaryList="300";
    private String waterList="148.5";

    private String salariesString;
    private String waterString;

//    @Pattern(regexp = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", message = "Invalid Number")
    private String dieselBaseRate="2";


    private String currentRate="2.23";
    private String salaryPerHour="0.0";

    private String salaryRevenue="0.0";

    private String rentalTanker="0.0";

    private String disposalPlace="0.0";

    private String washTanker="0.0";


    private double fixedCost;

    private String markUpPrecentage="0.0";

    public String getMarkUpPrecentage() {
        return markUpPrecentage;
    }

    public void setMarkUpPrecentage(String markUpPrecentage) {
        this.markUpPrecentage = markUpPrecentage;
    }

    public String getSizeOfTanker() {
        return sizeOfTanker;
    }

    public void setSizeOfTanker(String sizeOfTanker) {
        this.sizeOfTanker = sizeOfTanker;
    }

    public double getFuelSurchargeRate() {
        return fuelSurchargeRate;
    }

    public void setFuelSurchargeRate(double fuelSurchargeRate) {
        this.fuelSurchargeRate = fuelSurchargeRate;
    }

    public String getDistanceToBuyer() {
        return distanceToBuyer;
    }

    public void setDistanceToBuyer(String distanceToBuyer) {
        this.distanceToBuyer = distanceToBuyer;
    }

    public String getDistanceToMill() {
        return distanceToMill;
    }

    public void setDistanceToMill(String distanceToMill) {
        this.distanceToMill = distanceToMill;
    }

    public String getDistanceToBase() {
        return distanceToBase;
    }

    public void setDistanceToBase(String distanceToBase) {
        this.distanceToBase = distanceToBase;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStandByTime() {
        return standByTime;
    }

    public void setStandByTime(String standByTime) {
        this.standByTime = standByTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(String salaryList) {
        this.salaryList = salaryList;
    }

    public String getWaterList() {
        return waterList;
    }

    public void setWaterList(String waterList) {
        this.waterList = waterList;
    }

    public String getSalariesString() {
        return salariesString;
    }

    public void setSalariesString(String salariesString) {
        this.salariesString = salariesString;
    }

    public String getWaterString() {
        return waterString;
    }

    public void setWaterString(String waterString) {
        this.waterString = waterString;
    }

    public String getDieselBaseRate() {
        return dieselBaseRate;
    }

    public void setDieselBaseRate(String dieselBaseRate) {
        this.dieselBaseRate = dieselBaseRate;
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public String getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(String salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getSalaryRevenue() {
        return salaryRevenue;
    }

    public void setSalaryRevenue(String salaryRevenue) {
        this.salaryRevenue = salaryRevenue;
    }

    public String getRentalTanker() {
        return rentalTanker;
    }

    public void setRentalTanker(String rentalTanker) {
        this.rentalTanker = rentalTanker;
    }

    public String getDisposalPlace() {
        return disposalPlace;
    }

    public void setDisposalPlace(String disposalPlace) {
        this.disposalPlace = disposalPlace;
    }

    public String getWashTanker() {
        return washTanker;
    }

    public void setWashTanker(String washTanker) {
        this.washTanker = washTanker;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }
}
