package bot.Fade.LineUps.service;

import bot.Fade.LineUps.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot(BotConfig config){
        this.config = config;
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String filePath = "F:\\LineUps\\src\\main\\resources\\static\\video\\";
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText){
                case "/start":
                    startCommand(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "Ascent":
                    break;
                case "Icebox":
                    break;
                default: sendMessage(chatId,"Извини, но такой команды я не знаю :(");
            }
        }
        else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            if(callbackData.equals("ASCENT")){
                sendMessageButtonMap(chatId,1);
            }
            else if(callbackData.equals("ICEBOX")){
                sendMessageButtonMap(chatId,2);
            }
            else if(callbackData.equals("ASCENT_ATTACK")){
                sendMessageButtonAttack(chatId,1);
            }
            else if(callbackData.equals("ASCENT_DEFENSE")){
                sendMessageButtonDefense(chatId,1);
            }
            else if(callbackData.equals("ICEBOX_ATTACK")){
                sendMessageButtonAttack(chatId,2);
            }
            else if(callbackData.equals("ICEBOX_DEFENSE")){
                sendMessageButtonDefense(chatId,2);
            }


            else if(callbackData.equals("IceBox_Attack_Side_A(1)")){
                sendVideo(chatId,"Side A(1)", filePath + "attack\\icebox\\IceBox_Attack_Side_A(1).mp4");
            }
            else if(callbackData.equals("IceBox_Attack_Side_A(2)")){
                sendVideo(chatId,"Side A(2)", filePath + "attack\\icebox\\IceBox_Attack_Side_A(2).mp4");
            }
            else if(callbackData.equals("IceBox_Attack_Mid")){
                sendVideo(chatId,"Mid", filePath + "attack\\icebox\\IceBox_Attack_Mid.mp4");
            }
            else if(callbackData.equals("IceBox_Attack_Orange_B")){
                sendVideo(chatId,"Orange B", filePath + "attack\\icebox\\IceBox_Attack_Orange_B.mp4");
            }
            else if(callbackData.equals("IceBox_Attack_Yellow_B")){
                sendVideo(chatId,"Yellow B", filePath + "attack\\icebox\\IceBox_Attack_Yellow_B.mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Long_B(1)")){
                sendVideo(chatId,"Long B(1)", filePath + "defense\\icebox\\IceBox_Defense_Long_B(1).mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Long_B(2)")){
                sendVideo(chatId,"Long B(2)", filePath + "defense\\icebox\\IceBox_Defense_Long_B(2).mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Main_A(1)")){
                sendVideo(chatId,"Main A(1)", filePath + "defense\\icebox\\IceBox_Defense_Main_A(1).mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Main_A(2)")){
                sendVideo(chatId,"Main A(2)", filePath + "defense\\icebox\\IceBox_Defense_Main_A(2).mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Mid")){
                sendVideo(chatId,"Mid", filePath + "defense\\icebox\\IceBox_Defense_Mid.mp4");
            }
            else if(callbackData.equals("IceBox_Defense_Side_B")){
                sendVideo(chatId,"Side B", filePath + "defense\\icebox\\IceBox_Defense_Side_B.mp4");
            }


            else if(callbackData.equals("Ascent_Defense_Area_B")){
                sendVideo(chatId,"Area B", filePath + "defense\\ascent\\Ascent_Defense_Area_B.mp4");
            }
            else if(callbackData.equals("Ascent_Defense_Main_A(1)")){
                sendVideo(chatId,"Main A(1)", filePath + "defense\\ascent\\Ascent_Defense_Main_A(1).mp4");
            }
            else if(callbackData.equals("Ascent_Defense_Main_A(2)")){
                sendVideo(chatId,"Main A(2)", filePath + "defense\\ascent\\Ascent_Defense_Main_A(2).mp4");
            }
            else if(callbackData.equals("Ascent_Defense_Main_B")){
                sendVideo(chatId,"Main B", filePath + "defense\\ascent\\Ascent_Defense_Main_B.mp4");
            }
            else if(callbackData.equals("Ascent_Defense_Site_A")){
                sendVideo(chatId,"Site A", filePath + "defense\\ascent\\Ascent_Defense_Site_A.mp4");
            }
            else if(callbackData.equals("Ascent_Defense_Site_B")){
                sendVideo(chatId,"Site B", filePath + "defense\\ascent\\Ascent_Defense_Site_B.mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Mid")){
                sendVideo(chatId,"Mid", filePath + "attack\\ascent\\Ascent_Attack_Mid.mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Tree")){
                sendVideo(chatId,"Tree", filePath + "attack\\ascent\\Ascent_Attack_Tree.mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Site_A(1)")){
                sendVideo(chatId,"Site A(1)", filePath + "attack\\ascent\\Ascent_Attack_Site_A(1).mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Site_A(2)")){
                sendVideo(chatId,"Site A(2)", filePath + "attack\\ascent\\Ascent_Attack_Site_A(2).mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Site_B(1)")){
                sendVideo(chatId,"Site B(1)", filePath + "attack\\ascent\\Ascent_Attack_Site_B(1).mp4");
            }
            else if(callbackData.equals("Ascent_Attack_Site_B(2)")){
                sendVideo(chatId,"Site B(2)", filePath + "attack\\ascent\\Ascent_Attack_Site_B(2).mp4");
            }
        }
    }

    private void startCommand(long chatId, String name){
        String answer = "Привет, " + name + "! Этот бот позволяет узнать различные раскидки на картах Ascent, Icebox " +
                "на таком агенте, как Fade. Дальше тебе нужно будет выбрать нужную тебе карту, а также " +
                "выбрать сторону: Атака или Защита.";
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(answer);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        var Ascent = new InlineKeyboardButton();
        Ascent.setText("Ascent");
        Ascent.setCallbackData("ASCENT");
        rowInline.add(Ascent);
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();

        var Icebox = new InlineKeyboardButton();
        Icebox.setText("Icebox");
        Icebox.setCallbackData("ICEBOX");
        rowInline.add(Icebox);
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);
        } catch (TelegramApiException e) {}
    }

    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e) {}
    }

    private void sendMessageButtonMap(long chatId, int map){
        String[] nameMap = new String[]{"Карта: Ascent.", "Карта: Icebox."};
        String[] attackMap = new String[]{"ASCENT_ATTACK", "ICEBOX_ATTACK"};
        String[] defenseMap = new String[]{"ASCENT_DEFENSE", "ICEBOX_DEFENSE"};

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(nameMap[map-1]);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        var Attack = new InlineKeyboardButton();
        Attack.setText("Атака");
        Attack.setCallbackData(attackMap[map-1]);
        rowInline.add(Attack);
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();

        var Defense = new InlineKeyboardButton();
        Defense.setText("Защита");
        Defense.setCallbackData(defenseMap[map-1]);
        rowInline.add(Defense);
        rowsInline.add(rowInline);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);
        } catch (TelegramApiException e) {}
    }

    private void sendMessageButtonAttack(long chatId, int map){
        String[][] positions = {{"Mid","Tree","Site A(1)","Site A(2)","Site B(1)","Site B(2)"},
                                {"Mid","Orange B","Yellow B","Side A(1)","Side A(2)"},};
        String[][] posCall = {{"Ascent_Attack_Mid","Ascent_Attack_Tree","Ascent_Attack_Site_A(1)","Ascent_Attack_Site_A(2)","Ascent_Attack_Site_B(1)","Ascent_Attack_Site_B(2)"},
                              {"IceBox_Attack_Mid","IceBox_Attack_Orange_B","IceBox_Attack_Yellow_B","IceBox_Attack_Side_A(1)","IceBox_Attack_Side_A(2)"}};
        String[] nameMap = new String[]{"Ascent.","Icebox."};

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        String text = "Раскидки за атаку на " + nameMap[map-1];
        message.setText(text);

        InlineKeyboardButton pos;
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        for(int i = 0; i < positions[map-1].length; i++){
            pos = new InlineKeyboardButton();
            pos.setText(positions[map-1][i]);
            pos.setCallbackData(posCall[map-1][i]);
            rowInline.add(pos);
            rowsInline.add(rowInline);
            rowInline = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);
        } catch (TelegramApiException e) {}
    }
    private void sendMessageButtonDefense(long chatId, int map){
        String[][] positions = {{"Area B","Main A(1)","Main A(2)","Main B","Site A","Site B"},{"Long B(1)","Long B(2)","Main A(1)","Main A(2)","Mid","Side B"}};
        String[][] posCall = {{"Ascent_Defense_Area_B","Ascent_Defense_Main_A(1)","Ascent_Defense_Main_A(2)","Ascent_Defense_Main_B","Ascent_Defense_Site_A","Ascent_Defense_Site_B.mp4"},
                              {"IceBox_Defense_Long_B(1)","IceBox_Defense_Long_B(2)","IceBox_Defense_Main_A(1)","IceBox_Defense_Main_A(2)","IceBox_Defense_Mid","IceBox_Defense_Side_B"}};
        String[] nameMap = new String[]{"Ascent.", "Icebox."};

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        String text = "Раскидки за защиту на " + nameMap[map-1];
        message.setText(text);

        InlineKeyboardButton pos;
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        for(int i = 0; i < positions[map-1].length; i++){
            pos = new InlineKeyboardButton();
            pos.setText(positions[map-1][i]);
            pos.setCallbackData(posCall[map-1][i]);
            rowInline.add(pos);
            rowsInline.add(rowInline);
            rowInline = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);
        } catch (TelegramApiException e) {}
    }
    private void sendVideo(long chatId, String imageCaption, String imagePath){
        SendVideo sendVideo = new SendVideo();
        sendVideo.setVideo(new InputFile(new File(imagePath)));
        sendVideo.setChatId(String.valueOf(chatId));
        sendVideo.setCaption(imageCaption);
        try {
            execute(sendVideo);
        } catch (TelegramApiException e) {}
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
