package study.domainboardwriter;

public record PostByMemberCommand(
        String title,
        String content,
        String requestMemberName
) {

}
