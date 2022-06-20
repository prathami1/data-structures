class Citizen implements Comparable<Citizen> {

    private String firstName;
    private String lastName;
    private String street;
    private String streetNumber;
    private String relation;
    private String renting;
    private Double propertyValue;
    private String gender;
    private Double age;
    private String maritalStatus;
    private Integer ageAtFirstMarriage;
    private String attendSchool;
    private String canRead;
    private String birthplace;
    private String fatherBirthplace;
    private String motherBirthplace;
    private String motherTongue;
    private Integer yearImmigrated;
    private String occupation;
    private String industry;
    private String remarks;

    public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, String renting, double propertyValue, String gender, double age, String maritalStatus, int ageAtFirstMarriage, String attendSchool, String canRead, String birthplace, String fatherBirthplace, String motherBirthplace, String motherTongue, int yearImmigrated, String occupation, String industry, String remarks) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.relation = relation;
        this.renting = renting;
        this.propertyValue = propertyValue;
        this.gender = gender;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.ageAtFirstMarriage = ageAtFirstMarriage;
        this.attendSchool = attendSchool;
        this.canRead = canRead;
        this.birthplace = birthplace;
        this.fatherBirthplace = fatherBirthplace;
        this.motherBirthplace = motherBirthplace;
        this.motherTongue = motherTongue;
        this.yearImmigrated = yearImmigrated;
        this.occupation = occupation;
        this.industry = industry;
        this.remarks = remarks;
    }

    public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, String renting, String propertyValue, String gender, String age, String maritalStatus, String ageAtFirstMarriage, String attendSchool, String canRead, String birthplace, String fatherBirthplace, String motherBirthplace, String mothersTongue, String yearImmigrated, String occupation, String industry, String remarks) 
    { this(firstName.equals(".") ? null : firstName, lastName.equals(".") ? null : lastName, street, streetNumber, relation, (renting.equals(".") || renting.equals("un") || renting.equals("")) ? null : renting, (propertyValue.equals(".") || propertyValue.equals("un") || propertyValue.equals("")) ? -1 : (propertyValue.contains(" ") ? fedCensus.splitMixedNumber(propertyValue) : fedCensus.toDouble(propertyValue)), gender.equals(".") ? null : gender, (age.equals(".") || age.equals("un") || age.equals("")) ? -1 : fedCensus.splitMixedNumber(age), maritalStatus.equals(".") ? null : maritalStatus, (ageAtFirstMarriage.equals(".") || ageAtFirstMarriage.equals("un") || ageAtFirstMarriage.equals("")) ? -1 : (ageAtFirstMarriage.equals(".") ? -1 : Integer.parseInt(ageAtFirstMarriage)), attendSchool, canRead, birthplace, fatherBirthplace, motherBirthplace, mothersTongue, (yearImmigrated.equals(".") || yearImmigrated.equals("un") || yearImmigrated.equals("")) ? -1 : Integer.parseInt(yearImmigrated), occupation, industry, remarks); }

    @Override
    public String toString() {
        return String.format("%-25sAge: %s", lastName + ", " + firstName, age);
    }

    @Override
    public int compareTo(Citizen o) {
        if (firstName.compareTo(o.getFirstName()) != 0)
            return firstName.compareTo(o.getFirstName());
        else if (lastName.compareTo(o.getLastName()) != 0)
            return lastName.compareTo(o.getLastName());
        else if (street.compareTo(o.getStreet()) != 0)
            return street.compareTo(o.getStreet());
        else if (streetNumber.compareTo(o.getStreetNumber()) != 0)
            return streetNumber.compareTo(o.getStreetNumber());
        else if (relation.compareTo(o.getRelation()) != 0)
            return relation.compareTo(o.getRelation());
        else if (renting.compareTo(o.getRenting()) != 0)
            return renting.compareTo(o.getRenting());
        else if (propertyValue.compareTo(o.getPropertyValue()) != 0)
            return propertyValue.compareTo(o.getPropertyValue());
        else if (gender.compareTo(o.getGender()) != 0)
            return gender.compareTo(o.getGender());
        else if (age.compareTo(o.getAge()) != 0)
            return age.compareTo(o.getAge());
        else if (maritalStatus.compareTo(o.getMaritalStatus()) != 0)
            return maritalStatus.compareTo(o.getMaritalStatus());
        else if (ageAtFirstMarriage.compareTo(o.getAgeAtFirstMarriage()) != 0)
            return ageAtFirstMarriage.compareTo(o.getAgeAtFirstMarriage());
        else if (attendSchool.compareTo(o.getAttendSchool()) != 0)
            return attendSchool.compareTo(o.getAttendSchool());
        else if (canRead.compareTo(o.getCanRead()) != 0)
            return canRead.compareTo(o.getCanRead());
        else if (birthplace.compareTo(o.getBirthplace()) != 0)
            return birthplace.compareTo(o.getBirthplace());
        else if (fatherBirthplace.compareTo(o.getfatherBirthplace()) != 0)
            return fatherBirthplace.compareTo(o.getfatherBirthplace());
        else if (motherBirthplace.compareTo(o.getmotherBirthplace()) != 0)
            return motherBirthplace.compareTo(o.getmotherBirthplace());
        else if (motherTongue.compareTo(o.getMotherTongue()) != 0)
            return motherTongue.compareTo(o.getMotherTongue());
        else if (yearImmigrated.compareTo(o.getYearImmigrated()) != 0)
            return yearImmigrated.compareTo(o.getYearImmigrated());
        else if (occupation.compareTo(o.getOccupation()) != 0)
            return occupation.compareTo(o.getOccupation());
        else if (industry.compareTo(o.getIndustry()) != 0)
            return industry.compareTo(o.getIndustry());
        else if (remarks.compareTo(o.getRemarks()) != 0)
            return remarks.compareTo(o.getRemarks());
        else
            return 0;
    }

    public String getFirstName() 
    { return firstName; }

    public void setFirstName(String firstName) 
    { this.firstName = firstName; }

    public String getLastName() 
    { return lastName; }

    public void setLastName(String lastName) 
    { this.lastName = lastName; }

    public String getStreet() 
    { return street; }

    public void setStreet(String street) 
    { this.street = street; }

    public String getStreetNumber() 
    { return streetNumber; }

    public void setStreetNumber(String streetNumber) 
    { this.streetNumber = streetNumber; }

    public String getRelation() 
    { return relation; }

    public void setRelation(String relation) 
    { this.relation = relation; }

    public String getRenting() 
    { return renting; }

    public void setRenting(String renting) 
    { this.renting = renting; }

    public double getPropertyValue() 
    { return propertyValue; }

    public void setPropertyValue(double propertyValue) 
    { this.propertyValue = propertyValue; }

    public String getGender() 
    { return gender; }

    public void setGender(String gender) 
    { this.gender = gender; }

    public double getAge() 
    { return age; }

    public void setAge(double age) 
    { this.age = age; }

    public String getMaritalStatus() 
    { return maritalStatus; }

    public void setMaritalStatus(String maritalStatus) 
    { this.maritalStatus = maritalStatus; }

    public int getAgeAtFirstMarriage() 
    { return ageAtFirstMarriage; }

    public void setAgeAtFirstMarriage(int ageAtFirstMarriage) 
    { this.ageAtFirstMarriage = ageAtFirstMarriage; }

    public String getAttendSchool() 
    { return attendSchool; }

    public void setAttendSchool(String attendSchool) 
    { this.attendSchool = attendSchool; }

    public String getCanRead() 
    { return canRead; }

    public void setCanRead(String canRead) 
    { this.canRead = canRead; }

    public String getBirthplace() 
    { return birthplace; }

    public void setBirthplace(String birthplace) 
    { this.birthplace = birthplace; }

    public String getfatherBirthplace() 
    { return fatherBirthplace; }

    public void setfatherBirthplace(String fatherBirthplace) 
    { this.fatherBirthplace = fatherBirthplace; }

    public String getmotherBirthplace() 
    { return motherBirthplace; }

    public void setmotherBirthplace(String motherBirthplace) 
    { this.motherBirthplace = motherBirthplace; }

    public String getMotherTongue()
    { return motherTongue; }

    public void setMotherTongue(String motherTongue)
    { this.motherTongue = motherTongue; }

    public int getYearImmigrated()
    { return yearImmigrated; }
    

    public void setYearImmigrated(int yearImmigrated)
    { this.yearImmigrated = yearImmigrated; }

    public String getOccupation() 
    { return occupation; }

    public void setOccupation(String occupation) 
    { this.occupation = occupation; }

    public String getIndustry()
    { return industry; }

    public void setIndustry(String industry)
    { this.industry = industry; }

    public String getRemarks()
    { return remarks; }

    public void setRemarks(String remarks)
    { this.remarks = remarks; }
}