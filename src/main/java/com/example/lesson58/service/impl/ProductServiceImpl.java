package com.example.lesson58.service.impl;

import com.example.lesson58.entity.Product;
import com.example.lesson58.exeption.ResourceNotFound;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.ProductPayload;
import com.example.lesson58.repository.AttachmentRepository;
import com.example.lesson58.repository.ProductRepository;
import com.example.lesson58.service.AttachmentService;
import com.example.lesson58.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AttachmentService attachmentService;
    private final Result result;
    private final AttachmentRepository attachmentRepository;
    private final CategoryServiceImpl categoryService;
    @Override
    public Result add(ProductPayload productPayload) {
        try {
            Product product=Product.builder()
                    .price(productPayload.getPrice())
                    .description(productPayload.getDescription())
                    .name(productPayload.getName())
                    .image(attachmentRepository.findAttachmentByHashId(productPayload.getHashId()))
                    .category(categoryService.findById(productPayload.getCategoryId()))
                    .build();
            productRepository.save(product);
            return result.success(product);
        }catch (Exception e) {
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFound("product","id",id));
            String hashId=product.getImage().getHashId();
            productRepository.delete(product);
            attachmentService.deleteAttachmentByHashId(hashId);
            return result.success("product deleted");
        }catch (Exception e){
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result edit(ProductPayload productPayload,Long id) {
//        try {
//
//            Product product=Product.builder()
//                    .id(id)
//                    .name(productPayload.getName())
//                    .description(productPayload.getDescription())
//                    .price(productPayload.getPrice())
//                    .image(attachmentRepository.findAttachmentByHashId(productPayload.getHashId()))
//                    .build();
//
//            productRepository.save(product);
//
//            return result.success(product);
//        }catch (Exception e){
//            log.error(e.getMessage());
//            return result.failed(e.getMessage());
//        }
        return null;
    }

    @Override
    public Result findById(Long id) {

        try {
            Product product=productRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFound("product","id",id));

            return result.success(product);
        }catch (Exception e){
            return result.failed(e.getMessage());
        }
    }

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFound("product","id",id));
    }

    @Override
    public Result findAll(int pageSize,int pageNo) {
//        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by("createdAt"));
        return new Result("succsess",true,productRepository.getAll(),null);
    }
}
