package com.data2.coding4j;

interface AnonymousInnerClass {
    void test();
}

public class InnerClassExample {
    public static void main(String[] args) {
        MemberInnerClassPeople.Address m =
                new MemberInnerClassPeople().new Address();

        StaticInnerClassPeople.Address s =
                new StaticInnerClassPeople.Address();

        new PartInnerClassPeople().eat();

        AnonymousInnerClass a = new AnonymousInnerClass() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };

    }

}

class MemberInnerClassPeople {
    String name;

    class Address {
        String city;
    }
}

class StaticInnerClassPeople {
    String name;

    static class Address {
        String city;
    }
}

class PartInnerClassPeople {
    String name;

    void eat() {
        class Food {
            String apple;
        }
        String food = new Food().apple;
    }
}

