public class notebook {
    
    private String color;
    private Integer RAM;
    private String OS;
    private Integer HDD;
    private String brand;
    private String model;
   

    public notebook(String model, String brand){
        this.model = model;
        this.brand = brand;
        System.out.println("Ноутбук марки " + this.brand + " Модель " + this.model);
    }
    public String getColor(){
        return this.color;
    }
    public Integer getRAM(){
        return this.RAM;
    }
    public String getOS(){
        return this.OS;
    }
    public Integer getHDD(){
        return this.HDD;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public void setColor(String color){
        this.color =color;
    }
    public void setRAM(Integer RAM){
        this.RAM = RAM;
    }
    public void setOS(String OS){
        this.OS = OS;
    }
    public void setHDD(Integer HDD){
        this.HDD = HDD;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ноутбук ");
        sb.append(System.lineSeparator());
        sb.append(this.color);
        sb.append(" ");
        sb.append(this.brand);
        sb.append(" ");
        sb.append(this.model);
        sb.append(System.lineSeparator());
        sb.append("OS "+this.OS);
        sb.append(System.lineSeparator());
        sb.append("HDD "+this.HDD);
        sb.append(System.lineSeparator());
        sb.append("RAM "+this.RAM);
        sb.append(System.lineSeparator());  
        return(sb.toString());
    }
}