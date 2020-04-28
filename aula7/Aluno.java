package aula7;

class Aluno {
    
    private String name;
    private int std_number;
    private int phone_number;
    
    public Aluno(String name, int std_number, int phone_number){
        this.name = name;
        this.std_number = std_number;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStd_number() {
        return std_number;
    }

    public void setStd_number(int std_number) {
        this.std_number = std_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
    
    
}
