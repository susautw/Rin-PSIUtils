package me.susautw.rin_psiutils.utils.reflection;

class FakeClassA {
    static String staticMethodA(){
        return FakeClassA.class.getName();
    }

    static String staticMethodB(){
        return FakeClassA.class.getName();
    }

    String methodA(){
        return FakeClassA.class.getName();
    }

    String methodB(){
        return FakeClassA.class.getName();
    }
}

class FakeClassB extends FakeClassA{
    static String staticMethodB(){
        return FakeClassB.class.getName();
    }

    String methodB(){
        return FakeClassB.class.getName();
    }

    String methodD(String inp){
        return inp;
    }
}