package exercicio4.usuarioDeSistema;

public abstract class User {
    protected String name;
    protected String email;
    protected String password;
    protected boolean isAdmin;

    public User(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void login() {
        System.out.println(name + " realizou login no sistema.");
    }

    public void logout() {
        System.out.println(name + " realizou logoff do sistema.");
    }

    public void updateData(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
        System.out.println("Dados alterados com sucesso para: " + newName + ", " + newEmail);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Senha alterada com sucesso.");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public abstract void checkSales();
}