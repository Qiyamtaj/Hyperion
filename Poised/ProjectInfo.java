public class ProjectInfo {
    // Attributes

    String projectName;
    int projectNum;
    String buildType;
    String projectAddress;
    int erfNumber;
    int totalFee;
    int paidToDate;
    String deadline;

    // Methods
    public ProjectInfo(String projectName, int projectNum, String buildType, String projectAddress, int erfNumber,
                       int totalFee, int paidToDate, String deadline)
    {
        this.projectName = projectName;
        this.projectNum = projectNum;
        this.buildType = buildType;
        this.projectAddress = projectAddress;
        this.erfNumber = erfNumber;
        this.totalFee = totalFee;
        this.paidToDate = paidToDate;
        this.deadline = deadline;

    }

    public String toString(){

        return String.format("""
                                            Report "%s"
                ----------------------------------------------------------------
                Project number: %d
                Building Type: %s
                Project Address: %s
                ERF Number: %d
                Total Fee: %d
                Total amount paid to date: %d
                Deadline: %s
                ----------------------------------------------------------------
                                      Constructor Information
                ----------------------------------------------------------------
                """,projectName,projectNum,buildType,projectAddress,erfNumber,totalFee,paidToDate,deadline);

    }


}
