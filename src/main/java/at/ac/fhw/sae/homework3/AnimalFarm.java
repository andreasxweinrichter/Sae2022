package at.ac.fhw.sae.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {

    public static final Scanner in = new Scanner(System.in);
    private static final List<Animal> listOfAllAnimals = new ArrayList<>();

    static MainMenuAction showMainMenu() {
        printWichAction("Was möchten Sie tun: ");
        printWichAction("1. Tier hinzufügen\n" + "2. Tiere anzeigen\n" + "3. Tiere nach Art anzeigen\n" + "4. Tier entfernen\n" + "5. Programm beenden\n");
        int inputAction = Integer.parseInt(in.nextLine());
        return MainMenuAction.values()[inputAction-1];
    }

    public static void main(String[] args) {

//        MainMenuAction currentaction = showMainMenu();
//        while (currentaction != MainMenuAction.EXIT) {
//            if (currentaction == MainMenuAction.ADD_ANIMAL) {
//                addAnimal(listOfAllAnimals, in);
//            }

        while (true) {
            printWichAction("Was möchten Sie tun: ");
            printWichAction("1. Tier hinzufügen\n" + "2. Tiere anzeigen\n" + "3. Tiere nach Art anzeigen\n" + "4. Tier entfernen\n" + "5. Programm beenden\n");

            int inputAction = Integer.parseInt(in.nextLine());

            if (inputAction == 1) {
                addAnimal(listOfAllAnimals, in);

            } else if (inputAction == 2) {
                printAnimalListAll(listOfAllAnimals);

            } else if (inputAction == 3) {
                printWichAction("Welche Tierart möchten Sie sehen?\n" + "1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn\n");
                int inputRace = Integer.parseInt(in.nextLine());
                int counter = 1;
                printAnimalListByRace(listOfAllAnimals, inputRace, counter);

            } else if (inputAction == 4) {
                List<Integer> listOfAnimalsByRace = new ArrayList<>();
                printWichAction("Welche Tierart möchten Sie entfernen?\n" + "1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn\n");
                int inputDelRace = Integer.parseInt(in.nextLine());
                int counter = 1;

                printAnimalListByRaceDel(listOfAllAnimals, listOfAnimalsByRace, inputDelRace, counter);

                printWichAction("Geben Sie die Nummer des Tieres ein, das gelöscht werden soll: ");
                Integer numberDeletedAnimal = Integer.parseInt(in.next());
                int deleteAnimal = listOfAnimalsByRace.get(numberDeletedAnimal - 1);
                listOfAllAnimals.remove(deleteAnimal);

            } else if (inputAction == 5) {
                printWichAction("Das Programm wird jetzt beendet");
                break;
            } else {
                printWichAction("Diese Aktion ist nicht verfügbar. Geben Sie eine Nummer zwischen 1-4 ein!");
            }


        }
    }

    private static void printWichAction(String x) {
        System.out.println(x);
    }

    private static void printAnimalListAll(List<Animal> listOfAllAnimals) {
        int counter = 1;
        System.out.printf("| %-4s | %-8s | %-8s %n", "Nr.", "Id", "Name");
        printWichAction("------------------------------");
        for (Animal animal : listOfAllAnimals) {
            System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
            counter += 1;
        }
    }

    private static void addAnimal(List<Animal> listOfAllAnimals, Scanner in) {
        printWichAction("Welches Tier wollen Sie hinzufügen\n" + "1. Pferd\n" + "2. Kuh\n" + "3. Schwein\n" + "4. Huhn\n");
        Scanner in1 = new Scanner(System.in);
        int inputAppendAnimal = Integer.parseInt(in.next());
        printWichAction("Geben Sie einen Namen für das Tier ein: ");
        Scanner in2 = new Scanner(System.in);
        String inputName = in.next();
        printWichAction(inputName);

        if (inputAppendAnimal == 1) {
            listOfAllAnimals.add(new Horse(inputName));
        } else if (inputAppendAnimal == 2) {
            listOfAllAnimals.add(new Cow(inputName));
        } else if (inputAppendAnimal == 3) {
            listOfAllAnimals.add(new Pig(inputName));
        } else if (inputAppendAnimal == 4) {
            listOfAllAnimals.add(new Chicken(inputName));
        } else {
            printWichAction("Bitte geben Sie eine Zahl zwischen 1 und 4 ein!");
        }
    }

    private static void printAnimalListByRaceDel(List<Animal> listOfAllAnimals, List<Integer> listOfAnimalsByRace, int inputDelRace, int counter) {
        if (inputDelRace == 1) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Horse) {
                    listOfAnimalsByRace.add(listOfAllAnimals.indexOf(animal));
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputDelRace == 2) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Cow) {
                    listOfAnimalsByRace.add(listOfAllAnimals.indexOf(animal));
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputDelRace == 3) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Pig) {
                    listOfAnimalsByRace.add(listOfAllAnimals.indexOf(animal));
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputDelRace == 4) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Chicken) {
                    listOfAnimalsByRace.add(listOfAllAnimals.indexOf(animal));
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else {
            printWichAction("Geben Sie bitte eine Nummer zwischen 1 und 4 ein!");
        }
    }

    private static void printAnimalListByRace(List<Animal> listOfAllAnimals, int inputRace, int counter) {
        if (inputRace == 1) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Horse) {
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputRace == 2) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Cow) {
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputRace == 3) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Pig) {
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else if (inputRace == 4) {
            for (Animal animal : listOfAllAnimals) {
                if (animal instanceof Chicken) {
                    System.out.printf("| %-4s | %-8s | %-8s %n", counter, animal.getId(), animal.name);
                    counter += 1;
                }
            }
        } else {
            printWichAction("Geben Sie bitte eine Nummer zwischen 1 und 4 ein!");
        }
    }
}
