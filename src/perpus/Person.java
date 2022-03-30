package perpus;

public abstract class Person {
    private static final String TABEL = "person";
    private int IdPerson;
    private String nama;
    private String username;
    private String password;
    private int role;

    public Person() {
    }
        public Person(int idPerson, String nama, String username, String password) {
        IdPerson = idPerson;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }
    
    public Person(int idPerson, String nama, String username, String password, int role) {
        IdPerson = idPerson;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static String getTABEL() {
        return TABEL;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int idPerson) {
        IdPerson = idPerson;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}