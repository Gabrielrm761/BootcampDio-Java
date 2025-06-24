package exercicio3.carro;

public class CarController {
    private Car car;

    public CarController() {
        this.car = new Car();
    }

    public void turnOnCar() {
        if (!car.isOn()) {
            car.setOn(true);
            System.out.println("Carro ligado com sucesso!");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void turnOffCar() {
        if (car.isOn()) {
            if (car.getGear() == 0 && car.getSpeed() == 0) {
                car.setOn(false);
                System.out.println("Carro desligado com sucesso!");
            } else {
                System.out.println("Não é possível desligar o carro. Ele deve estar em ponto morto (marcha 0) e com velocidade 0 km/h.");
            }
        } else {
            System.out.println("O carro já está desligado.");
        }
    }

    public void accelerate() {
        if (!car.isOn()) {
            System.out.println("Não é possível acelerar. O carro está desligado.");
            return;
        }

        if (car.getGear() == 0) {
            System.out.println("Não é possível acelerar. O carro está em ponto morto.");
            return;
        }

        int newSpeed = car.getSpeed() + 1;

        if (validSpeedToChangeGear(newSpeed, car.getGear())) {
            if (newSpeed <= 120) {
                car.setSpeed(newSpeed);
                System.out.println("Acelerando. Velocidade atual: " + car.getSpeed() + " km/h");
            } else {
                System.out.println("Velocidade máxima atingida (120 km/h).");
            }
        } else {
            System.out.println("Não é possível acelerar. A marcha atual (" + car.getGear() +
                    ") não suporta a velocidade " + newSpeed + " km/h.");
        }
    }

    public void decelerate() {
        if (!car.isOn()) {
            System.out.println("Não é possível diminuir a velocidade. O carro está desligado.");
            return;
        }

        int newSpeed = car.getSpeed() - 1;

        if (newSpeed >= 0) {
            if (car.getGear() == 0 || validSpeedToChangeGear(newSpeed, car.getGear())) {
                car.setSpeed(newSpeed);
                System.out.println("Diminuindo velocidade. Velocidade atual: " + car.getSpeed() + " km/h");
            } else {
                System.out.println("Não é possível diminuir a velocidade. A marcha atual (" + car.getGear() +
                        ") não suporta a velocidade " + newSpeed + " km/h. Reduza a marcha primeiro.");
            }
        } else {
            System.out.println("Velocidade mínima atingida (0 km/h).");
        }
    }

    public void turnLeft() {
        if (!car.isOn()) {
            System.out.println("Não é possível virar. O carro está desligado.");
            return;
        }

        if (car.getSpeed() >= 1 && car.getSpeed() <= 40) {
            car.setSteeringWheel("Esquerda");
            System.out.println("Virando para esquerda.");
        } else {
            System.out.println("Não é possível virar. A velocidade deve estar entre 1 km/h e 40 km/h.");
        }
    }

    public void turnRight() {
        if (!car.isOn()) {
            System.out.println("Não é possível virar. O carro está desligado.");
            return;
        }

        if (car.getSpeed() >= 1 && car.getSpeed() <= 40) {
            car.setSteeringWheel("Direita");
            System.out.println("Virando para direita.");
        } else {
            System.out.println("Não é possível virar. A velocidade deve estar entre 1 km/h e 40 km/h.");
        }
    }

    public void shiftUp() {
        if (!car.isOn()) {
            System.out.println("Não é possível trocar marcha. O carro está desligado.");
            return;
        }

        if (car.getGear() < 6) {
            int newGear = car.getGear() + 1;

            if (validSpeedToChangeGear(car.getSpeed(), newGear)) {
                car.setGear(newGear);
                System.out.println("Marcha aumentada para " + car.getGear() + "ª.");
            } else {
                System.out.println("Não é possível aumentar para " + newGear +
                        "ª marcha. A velocidade atual (" + car.getSpeed() +
                        " km/h) não é compatível.");
            }
        } else {
            System.out.println("O carro já está na 6ª marcha (máxima).");
        }
    }

    public void downShift() {
        if (!car.isOn()) {
            System.out.println("Não é possível trocar marcha. O carro está desligado.");
            return;
        }

        if (car.getGear() > 0) {
            int newGear = car.getGear() - 1;

            if (newGear == 0 || validSpeedToChangeGear(car.getSpeed(), newGear)) {
                car.setGear(newGear);
                System.out.println("Marcha diminuída para " + car.getGear() + "ª.");
            } else {
                System.out.println("Não é possível diminuir para " + newGear +
                        "ª marcha. A velocidade atual (" + car.getSpeed() +
                        " km/h) não é compatível. Reduza a velocidade primeiro.");
            }
        } else {
            System.out.println("O carro já está em ponto morto (marcha 0).");
        }
    }

    public void statusCar() {
        System.out.println("\n--- STATUS DO CARRO ---");
        System.out.println("Estado: " + (car.isOn() ? "Ligado" : "Desligado"));
        System.out.println("Velocidade: " + car.getSpeed() + " km/h");
        System.out.println("Marcha: " + (car.getGear() == 0 ? "Ponto morto" : car.getGear() + "ª"));
        System.out.println("Direção: " + car.getSteeringWheel());
        System.out.println("------------------------\n");
    }

    private boolean validSpeedToChangeGear(int speed, int gear) {
        switch (gear) {
            case 1: return speed >= 0 && speed <= 20;
            case 2: return speed >= 20 && speed <= 40;
            case 3: return speed >= 40 && speed <= 60;
            case 4: return speed >= 60 && speed <= 80;
            case 5: return speed >= 80 && speed <= 100;
            case 6: return speed >= 100 && speed <= 120;
            default: return false;
        }
    }
}
