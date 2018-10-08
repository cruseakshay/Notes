class Exercise6<T> {
    T t;
    public Exercise6(T t){
        this.t = t;
    }
    @Override
    public String toString() {
        return t.toString();
    }
    public static void main(String[] args) {
        System.out.print(new Exercise6<String>("hi"));
        System.out.print(new Exercise6("there"));
    }
}