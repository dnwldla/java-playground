package generic;

public class GenericSample {

    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkDTO();
    }

    public void checkDTO() {
        CastingDTO castingDTO = new CastingDTO();
        castingDTO.setObject("2");
        //컴파일에 오류가 발생하지 않는다
        Integer str=(Integer)castingDTO.getObject();

        GenericDTO<Integer> genericDTO = new GenericDTO<>();
       //컴파일 시에 오류 발생
        //genericDTO.setObject("2");
    }
}
