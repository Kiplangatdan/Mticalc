package com.app.mticalc.db;

public class MtiCalcDetails {




    public MtiCalcDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    //tree
    int plantid;
    int plotId;
	private int treeid;
	private String treeno;
	private double treeheight;
	private double treedbh;
	private String treespecies;
	
	//pole
	
	private int poleid;
	private String poleno;
    private double poletd;
	private double polebd;
	private double polelength;
	
	
	

 ///plantation
    private String plant_no;
    private int userid;
    private String ownername;
    private String plantname;
    private String usage;
   
    private double area;
    private String spacing;
    private String date;
    private String latitude;
    private String longitude;

    //plot variable
    private int plot_plant_id;
    private String plot_plot_no;


    //this method recieves the tree details to be inserted into the database
    /*
    * @param
    * treeno,plantid from spiner,treeheight,treedbh
    * */
	public MtiCalcDetails(String treeno,int plotid,int plantid, double treeheight, double treedbh) {

        this.plantid=plantid;
        this.treeno=treeno;
       	this.treeheight = treeheight;
		this.treedbh = treedbh;
		this.plotId=plotid;
       
       // this.treespecies=treespecies;

	}
	

    public int getPlotId1(){
        return plotId;
    }
	public String getTreeNo() {
		return treeno ;
	}
	public void setTreeno(String treeno) {
		this.treeno = treeno;
	}
	
	//public void setTreespecies(String treespecies) {
	//	this.treespecies = treespecies;
	//}
	public double getTreeHeight() {
		return treeheight;
	}
    public int getPlantId1() {
        return plantid;
    }
    public void setPlantId1(int plantid){
        this.plantid=plantid;
    }
	public void setTreeheight(double treeheight) {
		this.treeheight = treeheight;
	}
    public double getTreedbh(){
       return this.treedbh;
   }
    public void setTreedbh(double treedbh){
        this.treedbh=treedbh;
    }
   
    public  int getPlantid1(){
        return plantid;
    }
    
    
    //poles
    public MtiCalcDetails(String poleno,int plotid,int plantid,double poletd,
			double polebd,double polelength) {

        this.plantid=plantid;
        this.poleno=poleno;
		this.poletd = poletd;
		this.polebd = polebd;
		this.polelength = polelength;
        this.plotId=plotid;
       
      

	}
	

    public int getPlotId(){
        return plotId;
    }
	
	public String getPoleNo() {
		return poleno ;
	}
	public void setPoleno(String poleno) {
		this.poleno = poleno;
	}

	//public void setTreespecies(String treespecies) {
	//	this.treespecies = treespecies;
	//}
	public int getPlantId() {
        return plantid;
    }
    public void setPlantId(int plantid){
        this.plantid=plantid;
    }
	
    public double getPoletd(){
        return this.poletd;
    }
     public void setPoletd(double poletd){
         this.poletd=poletd;
     }
     public double getPolebd(){
         return this.polebd;
     }
      public void setPolebd(double polebd){
          this.polebd=polebd;
      }
      public double getPoleLength(){
          return this.polelength;
      }
       public void setPolelength(double polelength){
           this.polelength=polelength;
       }
    public  int getPlantid(){
        return plantid;
    }
    
    
    //this method recieves the plant details and set them to be inserted into the database
    /*
    * @param
    * ownername,plantName,
    * treeSpecies,area,spacing,
    * date from datepicker,
    * latitude,longitude
    * image filepath
    * */
         public MtiCalcDetails( int userid,String plantName,String Plotno,String treespecies, double area, String spacing,
         
                           String latitude, String longitude,String date,String usage){

        this.plantname=plantName;
        this.area=area;
        this.spacing=spacing;
        this.date=date;
        this.latitude=latitude;
        this.longitude=longitude;
        this.treespecies = treespecies;
        this.usage=usage;
        this.userid=userid;

    }
    public String getUsage() {
			return usage;
		}


		public void setUsage(String usage) {
			this.usage = usage;
		}


	public String getOwnername(){
        return ownername;
    }
    public void setOwnername(String ownername){
        this.ownername=ownername;
    }
    public String getPlotname(){
        return plantname;
    }
    public  void setPlotname(String plantname){
        this.plantname=plantname;
    }
   
    public double getArea (){
        return area;
    }
    public  void setArea(double area){
        this.area=area;
    }
    public String getSpacing(){
        return spacing;
    }
    public void setSpacing(String spacing){
        this.spacing=spacing;
    }
    public String getDate(){
        return  date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getLatitude(){
        return latitude;
    }
    public void setLatitude(String latitude){
        this.latitude=latitude;
    }
    public String getLongitude(){
        return longitude;
    }
    public void setLongitude(String longitude){
        this.longitude=longitude;
    }

    public  void setPlotno(String Plotno){
        this.plant_no=Plotno;
    }
    public String getTreespecies() {
        return treespecies;
    }




    public int getUserid() {
        return userid;
    }
    public  void setUserid(int userid){
        this.userid=userid;
    }
    public int getTreeid(){
        return treeid;
    }
    public  void setTreeid(int treeid){
        this.treeid=treeid;
    }

    public int getPoleid(){
        return poleid;
    }
    public  void setPoleid(int poleid){
        this.poleid=poleid;
    }
    public String getplantNo() {

        return plant_no;
    }
    //constructor to for plot details
    public MtiCalcDetails(int plant_id,String plot_no){
     this.plot_plot_no=plot_no;
        this.plot_plant_id=plant_id;


    }
    public int getPlot_plant_id(){
       return plot_plant_id;
    }
    public String getPlot_plot_no(){
        return  plot_plot_no;
    }

}
