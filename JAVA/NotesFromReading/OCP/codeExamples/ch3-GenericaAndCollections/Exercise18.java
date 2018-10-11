class A{}
class B extends A{}
class C extends B{}

class D<C>{
    // which of the following lines will compile ?
    A a1 = new A();
    A a2 = new B();
    A a3 = new C();

    C c1 = new A();
    C c2 = new B();
    C c3 = new C();
}