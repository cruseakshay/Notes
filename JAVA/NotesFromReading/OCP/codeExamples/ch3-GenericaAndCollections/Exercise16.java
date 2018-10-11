class Generic<T>{
    public static void main(String[] args) {
        // which version will compile ?
        Generic<String> g = new Generic<>();
        Generic<String> g = new Generic<?>();
        Generic<String> g = new Generic<T>();
        
        Generic<Object> g = new Generic();

    }
}