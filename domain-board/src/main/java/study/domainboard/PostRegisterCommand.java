package study.domainboard;

public record PostRegisterCommand(
        String title,
        String content
) {
}
