package lets_get_certified.asignments;

import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) {

        System.out.println(a());

        System.out.println(b());

        System.out.println(c());

        System.out.println(d());

        Parent p = new Child();
        try {
            p.process();
        } catch (IOException e) {
            System.out.println("IOException caught");
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException caught");
        }
    }

    public static String a() {
        try {
            // Empty try block (no exception thrown)
        } catch (Exception e) {
            System.out.println("Exception occurred");
            return "exception";
        } finally {
            System.out.println("finally section...");
            return "finally";
        }
    }

    public static String b() {
        try {
            return "ok";
        } catch (Exception e) {
            System.out.println("Exception occurred");
            return "exception";
        } finally {
            System.out.println("finally section...");
        }
    }

    public static String c() {
        try {
            throw new Exception("Test exception");
        } catch (Exception e) {
            System.out.println("Exception occurred");
            return "exception";  // Return from catch block
        } finally {
            System.out.println("finally section...");
        }
    }

    public static String d() {
        try {
            return "ok";  // No exception is thrown here
        }
        // This block won't compile because the checked exceptions must be thrown
       /* catch (IOException | NoSuchMethodException | ClassNotFoundException e) {
            return "exception";
        } */ catch (RuntimeException e) {
            return "runtime exception";  // This will compile
        } catch (Exception e) {
            return "general exception";  // This will compile
        }

        /*
        i. Will Checked Exceptions Compile?
        No. Checked exceptions such as IOException, NoSuchMethodException,
        and ClassNotFoundException must be thrown in the try block to compile.
        Since no exceptions are thrown, it won't compile.

        ii. Will Catching RuntimeException Compile?
        Yes. RuntimeException is an unchecked exception,
        so it doesn't need to be explicitly thrown by the try block, and it will compile.

        iii. Will Catching Exception Compile?
        AYes. Catching Exception will compile because it is a general class
        that can handle both checked and unchecked exceptions.
        */
    }
}

class Parent {
    public void process() throws IOException, NoSuchMethodException {
        System.out.println("Processing in Parent");
    }
}


class Child extends Parent {
    /*@Override
    public void process() throws IOException, NoSuchMethodException {
        System.out.println("Processing in Child");
    }*/
    @Override
    public void process() throws IOException, NoSuchMethodException {
        System.out.println("Processing in Child");
    }
}

/*
No, there will be compilation error in this scenario.
Since Parent's method signature does not declare NoSuchMethodException,
it cannot be caught by the catch block for NoSuchMethodException
(it would cause a compilation error).
*/
