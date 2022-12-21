import java.util.*;

public class Main {

    public static void main(String[] args) {
        essay(10, 7, "hello my name is Bessie and this is my essay");
        System.out.println();

        split("()()()");// ["()", "()", "()"]
        split("((()))");// ["((()))"]
        split("((()))(())()()(()())");// ["((()))", "(())", "()", "()", "(()())"]
        split("((())())(()(()()))");// ["((())())", "(()(()()))"]
        System.out.println();

        toCamelCase("hello_edabit");// "helloEdabit"
        toSnakeCase("helloEdabit");// "hello_edabit"
        toCamelCase("is_modal_open");// "isModalOpen"
        toSnakeCase("getColor");// "get_color"
        System.out.println();

        overTime(9, 17, 30, 1.5);// "$240.00"
        overTime(16, 18, 30, 1.8);// "$84.00"
        overTime(13.25, 15, 30, 1.5);// "$52.50"
        System.out.println();

        BMI("205 pounds", "73 inches");// "27.0 Overweight"
        BMI("55 kilos", "1.65 meters");// "20.2 Normal weight"
        BMI("154 pounds", "2 meters");// "17.5 Underweight"
        System.out.println();

        bugger(39);// 3
        bugger(999);// 4
        bugger(4);// 0
        System.out.println();

        toStarShorthand("abbccc");// "ab*2c*3"
        toStarShorthand("77777geff");// "7*5gef*2"
        toStarShorthand("abc");// "abc"
        toStarShorthand("");// ""
        System.out.println();

        doesRhyme("Sam I am!", "Green eggs and ham.");// true
        doesRhyme("Sam I am!", "Green eggs and HAM.");// true
        doesRhyme("You are off to the races", "a splendid day.");// false
        doesRhyme("and frequently do?", "you gotta move.");// false
        System.out.println();

        trouble(451999277, 41177722899L);// True
        trouble(1222345, 12345);// False
        trouble(666789, 12345667);// True
        trouble(33789, 12345337);// False
        System.out.println();

        countUniqueBooks("AZYWABBCATTTA", 'A');// 4
        countUniqueBooks("$AA$BBCATT$C$$B$", '$');// 3
        countUniqueBooks("ZZABCDEF", 'Z');// 0
    }
    //1
    static void essay(int n, int k, String s) {
        String[] a = s.split(" ");  //делим строку по пробелам
        StringBuilder sum = new StringBuilder(); //переменная, к которой прибавляются слова без пробелов
        StringBuilder ans = new StringBuilder(); //переменная, к которой прибавляются слова с пробелами
        for (int i = 0; i < a.length; i++) {
            if ((sum.length() + a[i].length()) <= k) {  //если сумма длин строк sum и a[i] меньше k, то
                sum.append(a[i]);                       //к строке sum прибавляем a[i]
                ans.append(a[i] + " ");                 //к строке ans прибавляем a[i] и пробел
            } else {
                System.out.println(ans);    //иначе просто выводим sum и приравниваем a[i] переменным
                sum.setLength(0);
                sum.append(a[i]);
                ans.setLength(0);
                ans.append(a[i] + " ");
            }
            if (i==a.length-1)      //если слово последнее, то просто выводим его
                System.out.println(ans);
        }
    }
    //2
    static void split(String s) {
        int count = 0;  //переменная, подсчитывающая скобки
        String ans = "";    //переменная, принимающая кластер скобок
        for (int i = 0; i < s.length(); i++) {  //перебираем символы строки
            if (s.charAt(i) == '(') {   //если перед нами открывающая скобка, то
                count++;                //к count прибавляем 1
                ans+="(";               //к ans прибавляем "("
            } else {                    //иначе
                ans+=")";               //к ans прибавляем ")"
                count--;                //вычитаем из ans 1
            }
            if (count == 0) {           //если ans = 0 (кластер закрылся), то
                System.out.print(ans + "  "); //выводим его
                ans = "";                     //обнуляем ans
            }
        }
        System.out.println();      //по завершении цикла переходим на следующую строку
    }
    //3
    static void toCamelCase(String s) {
        StringBuilder ans = new StringBuilder(String.valueOf(s.charAt(0)));   //переменная ans, равная первому символу строки
        for (int i = 1; i < s.length(); i++) {      //перебираем символы, начиная со второго
            //если перед нами буква, то
            if (Character.isLetter(s.charAt(i)) && s.charAt(i-1) != '_') {
                ans.append(s.charAt(i));   //прибавляем ее к ans
            } else if (s.charAt(i-1) == '_') {
                //если предыдущий символ "_", то к ans прибавляем заглавный символ
                ans.append(String.valueOf(s.charAt(i)).toUpperCase());
            }
        }
        System.out.println(ans);
    }
    static void toSnakeCase(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length()-1; i++) {      //перебираем символы с первого до предпоследнего
            if (Character.isLetter(s.charAt(i)) && s.charAt(i+1)>'Z') { //если следующая буква строчная, то
                ans.append(String.valueOf(s.charAt(i)).toLowerCase());       //прибавляем ее к ans в нижнем регистре
            } else if (s.charAt(i+1)<'z') {                             //иначе
                ans.append(s.charAt(i)+"_");                                 //прибавляем букву и "_"
            }
        }
        ans.append(s.charAt(s.length()-1));
        System.out.println(ans); //выводим ans с последним символом
    }
    //4
    static void overTime(double start, double end, double pay, double mn) {
        if (end<=17) {   //если сверхурочных часов не было
            System.out.println((end - start) * pay);    //умножаем ставку на часы работы
        } else {         //иначе
            System.out.println( pay * ( (17 - start) + (end - 17)*mn) ); //умножаем множитель на кол-во сверхурочных часов
        }
    }
    //5
    static void BMI(String a, String b) {
        String[] x = a.split(" ");  //делим обе строки по пробелам
        String[] y = b.split(" ");
        double height = Double.parseDouble(x[0]);  //переменной height приравниваем 1й элемент массива x
        double weight = Double.parseDouble(y[0]);  //переменной weight приравниваем 1й элемент массива y
        if (x[1].equals("pounds"))  //если вес дан в фунтах
            height = height * 0.453592;  //переводим его в кг
        if (y[1].equals("inches"))  //если рост дан в дюймах
            weight = weight * 0.0254;   //переводим его в метры

        double bmi = height / Math.pow(weight, 2);  //рассчитываем индекс
        String result = String.format("%.1f",bmi);

        //сравниваем индекс с нормой и выводим результат
        if (bmi < 18.5) {
            System.out.println(result + " Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println(result + " Normal weight");
        } else {
            System.out.println(result + " Overweight");
        }
    }
    //6
    static void bugger(int a) {
        int count = 0;  //переменная, подсчитывающая число проходов через цикл
        while (a>10) {  //число проходит через цикл, пока оно больше 10
            int mult = 1;  //переменная, равная произведению цифр числа
            while (a!=0) {
                mult *= (a % 10); //умножаем mult на последнюю цифру числа
                a/= 10;   //отсекаем последнюю цифру
            }
            a = mult;  //к a приравниваем произведение
            count++;    //к count прибавляем 1
        }
        System.out.println(count);
    }
    //7
    static void toStarShorthand(String s) {
        StringBuilder ans = new StringBuilder();    //переменная, в которую записывается ответ
        int count = 1;      //переменная, считающая кол-во подряд идущих элементов
        char copy = ' ';    //переменная, которой приравниваются идущие подряд элементы
        for (int i = 0; i < s.length()-1; i++) {    //перебираем символы строки с 1 до предпоследнего
            if (s.charAt(i) == s.charAt(i+1)) {     //если символ равен следующему
                copy = s.charAt(i);                 //к copy приравниваем символ
                count++;                            //к count прибавляем 1
                //если символ последний в последовательности идущих подряд символов, то
            } else if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) == copy) {
                ans.append(copy + "*" + String.valueOf(count));    //выводим его, "*" и кол-во этих символов
                count = 1;  //count приравниваем к 1
                //если символ не повторяется, то просто прибавляем его к ans
            } else if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != copy) {
                ans.append(s.charAt(i));
            }
        }
        //проверка последнего символа
        //если строка не пустая и символ не является частью идущих подряд элементов, то просто прибавляем его к ans
        if (s.length()>0 && s.charAt(s.length()-1)!=copy) {
            ans.append(s.charAt(s.length() - 1));
            //иначе прибавляем символ, "*" и кол-во повторов
        } else if (s.length()>0 && s.charAt(s.length()-1)==copy) {
            ans.append(copy + "*" + String.valueOf(count));
        }
        System.out.println(" - "+ans);
    }
    //8
    static void doesRhyme(String a, String b) {
        a = a.toLowerCase();    //приводим обе строки к нижнему регистру
        b = b.toLowerCase();
        String[] vowels = new String[] {"a","e","i","o","u","y"};   //создаем массив с гласными
        String[] a1 = a.split(" ");     //разбиваем строки на отдельные слова
        String[] b1 = b.split(" ");
        String word1 = a1[a1.length-1];       //переменным word 1 и 2 приравниваем последние буквы
        String word2 = b1[b1.length-1];
        StringBuilder vowel1 = new StringBuilder();     //переменные vowel 1 и 2 - гласные, содержащиеся в последних словах
        StringBuilder vowel2 = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) { //перебираем символы последних слов
            if (Arrays.asList(vowels).contains(String.valueOf(word1.charAt(i))))  //если буква гласная, то
                vowel1.append(word1.charAt(i));                                          //добавляем ее в строку vowel
        }
        for (int i = 0; i < word2.length(); i++) {
            if (Arrays.asList(vowels).contains(String.valueOf(word2.charAt(i))))
                vowel2.append(word2.charAt(i));
        }
        System.out.println(vowel1.toString().equals(vowel2.toString()));      //сравниваем получившиеся строки и выводим результат
    }
    //9
    static void trouble(int a, long b) {
        String x = String.valueOf(a);   //x и y - строчные варианты чисел
        String y = String.valueOf(b);
        int ans = 0;  //переменная, в которую записывается 1, если символ повторяется три раза подряд в числе 1 и два раза числе 2
        for (int i = 0; i < x.length(); i++) { //перебираем все символы в первом числе
            int num1 = 1;   //переменная, равная числу повторов в первом числе
            int num2 = 1;   //переменная, равная числу повторов во втором числе
            for (int j = 0; j < x.length()-1; j++) {  //перебираем символы до предпоследнего в первом числе
                //если символ равен следующему и символу из основного цикла, то
                if ((x.charAt(i) == x.charAt(j)) && (x.charAt(j) == x.charAt(j+1))) {
                    num1++; //к num1 прибавляем 1
                }
            }
            for (int k = 0; k < y.length()-1; k++) {
                if ((x.charAt(i) == y.charAt(k)) && (y.charAt(k) == y.charAt(k+1))) {
                    num2++;
                }
            }
            if ((num1 == 3) && (num2 == 2)) {    //сравниваем num1 с 3 и num2 с 2
                ans = 1;//если вышло равенство, то приравниваем ans к 1
                break;
            }
        }
        System.out.println(ans == 1);   //сравниваем ans с 1 и выводим ответ
    }
    //10
    static void countUniqueBooks(String s, char end) {
        StringBuilder s1 = new StringBuilder();;     //переменная, принимающая символы между концами книги
        for (int i = 1; i < s.length(); i++) {          //перебираем символы со 2 по последний
            if (s.charAt(i-1) == end) {                 //если предыдущий символ - конец, то
                while (s.charAt(i) != end) {            //до тех пор, пока вновь не будет встречена конечная переменная
                    s1.append(String.valueOf(String.valueOf(s.charAt(i))));  //к переменной s1 прибавляем все встреченные символы
                    i++;
                }
                s = s.substring(0, i)+" "+s.substring(i+1, s.length()); //удаляем последний встреченный конечный символ их строки
            }
        }
        String[] a = s1.toString().split(""); //разбиваем строку s1 на отдельные элементы
        Arrays.sort(a);     //сортируем получившийся массив по возрастанию
        int count = 0;      //переменная, подсчитывающая кол-во повторов
        for (int i = 0; i < a.length-1; i++) {  //перебираем элементы массива до предпоследнего
            if (a[i].equals(a[i+1]))    //если следующий элемент равен текущему, то
                count++;                //к count прибавляем 1
        }
        System.out.println(s1.length()-count); //выводим разницу м-у числом символов в s1 и count
    }
}