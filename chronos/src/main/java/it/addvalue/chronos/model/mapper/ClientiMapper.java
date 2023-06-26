package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.clientiDTO;
import it.addvalue.chronos.model.entity.ClientiEntity;

import java.util.List;

public class ClientiMapper implements IDtoEntityBidirectionalMapper<clientiDTO, ClientiEntity> {
    @Override
    public clientiDTO toDto(ClientiEntity clientiEntity) {
        clientiDTO clientiDto = new clientiDTO();
        clientiDto.setCodCliente(clientiEntity.getCodCliente());
        clientiDto.setRagSociale(clientiEntity.getRagSociale());
        clientiDto.setCodCimav(String.valueOf(clientiEntity.getCodCimav()));
        clientiDto.setCodClientePant(clientiEntity.getCodClientePant());
        return clientiDto;
    }

    @Override
    public ClientiEntity toEntity(clientiDTO clientiDto) {
        ClientiEntity clientiEntity = new ClientiEntity();
        clientiEntity.setCodCliente(clientiDto.getCodCliente());
        clientiEntity.setRagSociale(clientiDto.getRagSociale());
        clientiEntity.setCodCimav(Integer.parseInt(clientiDto.getCodCimav()));
        clientiEntity.setCodClientePant(clientiDto.getCodClientePant());
        return clientiEntity;
    }

    @Override
    public List<clientiDTO> toDtos(List<ClientiEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<ClientiEntity> toEntities(List<clientiDTO> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
