package org.seleniumlessons;

public class CoreJavaBrushUp {
    public static void main(String[] args) {
        /*int num = 5;
        double num1 = 5.55555;
        long num2 = 534235234234234324L;
        String num3 = "5645445";

        System.out.println(num + num1);
        System.out.println(num3);
        System.out.println(num + num3);

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        int[] arr1 = {1, 3, 5 ,8 ,9};

        for (int j : arr1) {
            System.out.println(j);
        }

        String[] name = {"124132414", "120341", "123412"};
        for (String s : name) {
            System.out.println(s);
        }*/

        /*int[] array = {1, 2, 3, 4, 5, 6, 8};
        for (Integer in : array) {
            if (in % 2 == 0) {
                System.out.println(in);
            }
        }*/

        /*ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        System.out.println(a.get(3));

        ArrayList<String> s = new ArrayList<>();
        s.add("sdfa");
        s.add("sddqfa");
        s.add("sdasdqfa");
        s.remove(2);

        for (String w : s) {
            System.out.println(w);
        }

        s.contains("sddqfa");

        String[] names = {"adfdfsad", "asdfasdf", "sdfasd"};
        List<String> newNames = Arrays.asList(names);
        for (String str : newNames) {
            System.out.println(str);
        }
        System.out.println(newNames.contains("adfdfsad"));*/

        /*String name = "1234567890";
        String[] s = name.split(" ");
        for (String words : s ) {
            System.out.println(words.trim());
        }

        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }

        for (int i = name.length()-1; i < name.length(); i--) {
            System.out.println(name.charAt(i));
        }*/
        CoreJavaBrushUp user = new CoreJavaBrushUp();

        user.greet();
    }

    public void greet() {
        System.out.println("Hello world");
    }

}
